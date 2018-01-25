package com.example.tmd.oop_sang_thu5;

import java.util.Date;

/**
 * Created by tmd on 20/04/2017.
 */

public class OneWayTicket extends Ticket {
    private boolean mValid = true;

    public OneWayTicket(Date issuedDate, int value) {
        super(issuedDate, value);
    }

    public void setOrigin(Gate gate) {
        mGate = gate;
    }

    public boolean isValid() {
        if (mIssuedDate != Test.today){
            return false;
        }
        return true;
    }
}
