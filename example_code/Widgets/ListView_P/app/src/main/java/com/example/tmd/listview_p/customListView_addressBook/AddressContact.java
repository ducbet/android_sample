package com.example.tmd.listview_p.customListView_addressBook;

import java.io.Serializable;

/**
 * Created by tmd on 21/03/2017.
 */

public class AddressContact implements Serializable {
    private String name;
    private String phoneNumber;
    private int id;

    public AddressContact() {
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public AddressContact(int id, String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
}
