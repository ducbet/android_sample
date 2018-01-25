package com.example.tmd.javatest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by trieu_000 on 3/10/2017.
 */

public class collection {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello");
        arrayList.add("TMD");
        arrayList.add("abcd");
        arrayList.add("123");
        arrayList.add("Kimochi");
        arrayList.add(3, "Chen giua");
        arrayList.remove(2);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("----------------------------------");

        for (Object data : arrayList) {
            System.out.println(data);
        }
        Double d = new Double(5);
        double db = d;
        System.out.println(db);

        System.out.println("-----------------------------------");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(123, "TMD");
        map.put(124, "TRIEU MINH DUC");
        map.put(125, "HEDSPI");
        map.put(126, "BACH KHOA");
        for (String value : map.values()) {
            System.out.println(value);
        }
    }


}
