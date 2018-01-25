package com.example.tmd.accessingcontactsdata;

/**
 * Created by tmd on 23/04/2017.
 */

public class Contact {
    private String mName;
    private String mPhone = "";
    private String mAddress = "";

    public void setName(String name) {
        mName = name;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public void setAddress(String address) {
        mAddress = address;
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

    public Contact(String name) {
        mName = name;
    }

    public Contact(String name, String phone, String address) {
        mName = name;
        mPhone = phone;
        mAddress = address;
    }

    @Override
    public String toString() {
        return mName + " - " + mPhone + " - " + mAddress;
    }

}
