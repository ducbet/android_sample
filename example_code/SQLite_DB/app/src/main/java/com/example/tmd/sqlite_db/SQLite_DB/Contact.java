package com.example.tmd.sqlite_db.SQLite_DB;

/**
 * Created by tmd on 23/04/2017.
 */

public class Contact {
    private long mId = -1; // đặt thế nào cũng đc thì _ID do DB quản lý
    private String mName;
    private String mPhone = "";
    private String mAddress = "";

    public Contact(long id, String name, String phone, String address) {
        mId = id;
        mName = name;
        mPhone = phone;
        mAddress = address;
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

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
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
        return mId + " - " + mName + " - " + mPhone + " - " + mAddress;
    }

}
