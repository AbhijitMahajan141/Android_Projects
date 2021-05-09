package com.example.carvefood;

import android.os.Parcel;
import android.os.Parcelable;

public class Upload1 {
    //private String n;
    private String image_u, item_n, item_desc, item_ing, item_c, extra_ing, extra_msg, usr_id, vndr_id;

    public Upload1() {

    }

    public Upload1(String image_uri, String item_name, String item_description, String item_ingredients, String item_cost, String extra_ingredients, String extra_message, String user_id, String vendor_id) {

        image_u = image_uri;
        item_n = item_name;
        item_desc = item_description;
        item_ing = item_ingredients;
        item_c = item_cost;
        extra_ing = extra_ingredients;
        extra_msg = extra_message;
        usr_id = user_id;
        vndr_id = vendor_id;
    }

    public String getImage_u() {
        return image_u;
    }

    public void setImage_u(String image_u) {
        this.image_u = image_u;
    }

    public String getItem_n() {
        return item_n;
    }

    public void setItem_n(String item_n) {
        this.item_n = item_n;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_ing() {
        return item_ing;
    }

    public void setItem_ing(String item_ing) {
        this.item_ing = item_ing;
    }

    public String getItem_c() {
        return item_c;
    }

    public void setItem_c(String item_c) {
        this.item_c = item_c;
    }

    public String getExtra_ing() {
        return extra_ing;
    }

    public void setExtra_ing(String extra_ing) {
        this.extra_ing = extra_ing;
    }

    public String getExtra_msg() {
        return extra_msg;
    }

    public void setExtra_msg(String extra_msg) {
        this.extra_msg = extra_msg;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getVndr_id() {
        return vndr_id;
    }

    public void setVndr_id(String vndr_id) {
        this.vndr_id = vndr_id;
    }
}