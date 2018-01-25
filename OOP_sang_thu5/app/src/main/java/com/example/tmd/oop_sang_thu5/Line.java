package com.example.tmd.oop_sang_thu5;

/**
 * Created by tmd on 20/04/2017.
 */

public class Line {
    public static final Gate gateA = new Gate("A", 0);
    public static final Gate gateB = new Gate("B", 17);
    public static final Gate gateC = new Gate("C", 17 + 5);
    public static final Gate gateD = new Gate("D", 17 + 5 + 11);

    public static int getFare(int distance) {
        int price = 9000;
        double tmpDistance = distance - 6;
        price += ((int) Math.ceil(tmpDistance / 2.0)) * 2000;
        return price;
    }
}
