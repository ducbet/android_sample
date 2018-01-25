package com.example.tmd.javatest.interfaceComparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tmd on 19/03/2017.
 */

public class sortNhanVien {

    /*
    *   Sắp xếp ArrayList<NhanVien>
    * */

    public static void main(String[] args) {
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        list.add(new NhanVien(1, "TMD"));
        list.add(new NhanVien(5, "abcd"));
        list.add(new NhanVien(2, "b23432"));
        list.add(new NhanVien(7, "hello"));
        list.add(new NhanVien(3, "O2"));

        System.out.println("Danh sách nhân viên: ");
        for (NhanVien nv : list) {
            System.out.println(nv.toString());
        }

        System.out.println("Danh sách nhân viên sau khi sắp xếp: ");
        Collections.sort(list);

        for (NhanVien nv : list) {
            System.out.println(nv.toString());
        }
    }
}
