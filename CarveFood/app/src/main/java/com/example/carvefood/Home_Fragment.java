package com.example.carvefood;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home_Fragment extends Fragment implements RecyclerAdapter1.OnItemListener{

    Button logout;
    TextView user_email;
    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private RecyclerAdapter1 adapter;
    private ArrayList<Upload1> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        logout = v.findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getActivity(), Login_page.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        user_email = v.findViewById(R.id.user_email);

        //user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user_email.setText(user.getEmail());
        }
        String ids = user.getUid();

        DatabaseReference root = db.getReference().child("neworders");

        recyclerView = v.findViewById(R.id.orders_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        list = new ArrayList<>();
        adapter = new RecyclerAdapter1(this.getContext(),list,this);
        recyclerView.setAdapter(adapter);

        root.orderByChild("vendor").equalTo(ids).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Upload1 upload = dataSnapshot.getValue(Upload1.class);
                    list.add(upload);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onDeleteClick(int position) {

    }
}