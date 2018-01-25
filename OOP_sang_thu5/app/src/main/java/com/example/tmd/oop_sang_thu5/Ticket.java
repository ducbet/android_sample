package com.example.tmd.oop_sang_thu5;

import java.util.Date;

/**
 * Created by tmd on 20/04/2017.
 */

public abstract class Ticket {
    protected Date mIssuedDate;
    protected int mValue;
    protected Gate mGate = null;

    public Ticket(Date issuedDate, int value) {
        mIssuedDate = issuedDate;
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public void setOrigin(Gate gate) {
        mGate = gate;
    }

    public Gate getOrigin() {
        return mGate;
    }

    public void adjustValue(int value){
        mValue = value;
    }

    public abstract boolean isValid();
}
