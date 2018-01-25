package com.example.tmd.activity_p;

import java.io.Serializable;

/**
 * Created by tmd on 17/03/2017.
 */

public class SinhVien implements Serializable {
    /*
        - Là object được truyền giữa các activity (appLifeCycle->floatingWindow)
        - SinhVien implements Serializable
    */

    int MSSV;
    String name;

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMSSV() {
        return MSSV;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " có MSSV: " + MSSV;
    }

    public SinhVien() {

    }

    public SinhVien(int MSSV, String name) {
        this.MSSV = MSSV;
        this.name = name;
    }


}


