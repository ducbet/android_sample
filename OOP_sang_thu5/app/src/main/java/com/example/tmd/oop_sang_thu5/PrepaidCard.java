package com.example.tmd.oop_sang_thu5;

import java.util.Date;

/**
 * Created by tmd on 20/04/2017.
 */

public class PrepaidCard extends Ticket implements ICard {

    public PrepaidCard(Date issuedDate, int value) {
        super(issuedDate, value);
    }

    @Override
    public void add(int value) {
        mValue += value;
    }

    @Override
    public boolean deduct(int value) {
        if (mValue - value >= 0) {
            mValue -= value;
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (mValue >= 9000){// lon hon muc san
            return true;
        }
        return false;
    }
}
