package com.example.tmd.optionmenu_p.BTVN;

import android.widget.ImageView;

/**
 * Created by tmd on 16/04/2017.
 */

public class Contact {
    private int mID;
    private int mAvatar;
    private String mName;

    public void setAvatar(int avatar) {
        mAvatar = avatar;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    private String mPhone;
    private String mAddress;

    public int getID() {
        return mID;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getAddress() {
        return mAddress;
    }

    public Contact(int ID, String name, String phone, String address) {
        mID = ID;
        mName = name;
        mPhone = phone;
        mAddress = address;
    }

    public Contact(int ID, int avatar, String name, String phone, String address) {

        mID = ID;
        mAvatar = avatar;
        mName = name;
        mPhone = phone;
        mAddress = address;
    }
}
