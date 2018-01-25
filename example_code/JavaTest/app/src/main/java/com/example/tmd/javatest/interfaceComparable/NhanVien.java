package com.example.tmd.javatest.interfaceComparable;

import android.support.annotation.NonNull;

/**
 * Created by tmd on 19/03/2017.
 */

public class NhanVien implements Comparable<NhanVien> {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "ID: " + id + " - Name: " + name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public NhanVien() {
    }

    public NhanVien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull NhanVien o) {
        //return this.name.compareToIgnoreCase(o.getName());//sắp xếp theo tên

        // sắp xếp theo id
        if (this.id == o.getId()) {
            return 0;
        } else if (this.id > o.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
