package com.example.tmd.oop_sang_thu5;

/**
 * Created by tmd on 20/04/2017.
 */

public class Gate {
    private String mName;
    private int mDistance;
    private int mPrice;

    /******************/
    public int getDistance() {
        return mDistance;
    }
    /******************/

    public Gate(String name, int distance) {
        mName = name;
        mDistance = distance;
    }

    public void enter(Ticket ticket) {
        if (!ticket.isValid()) {
            if (ticket instanceof OneWayTicket) {
                System.out.println("Ticket invalid (not today's ticket), can't enter " + mName);
            } else {
                System.out.println("Ticket invalid (not enough 9000 VND, " +
                        "card have " + ticket.getValue() + "), can't enter " + mName);
            }
            close();
            return;
        }
        ticket.setOrigin(this);
        open();
    }

    public void exit(Ticket ticket) {
        if (ticket.getOrigin() == null) {
            return;
        }
        if (isEnoughMoney(ticket)) {
            open();
            return;
        }
        System.out.println("Not enough money to enter " + mName);
        close();
    }

    public void open() {
        System.out.println("Gate: " + mName + " open");
    }

    public void close() {
        System.out.println("Gate: " + mName + " close");
    }

    private boolean isEnoughMoney(Ticket ticket) {
        int distanceOrigin = ticket.getOrigin().getDistance();
        int price = Line.getFare(Math.abs(mDistance - distanceOrigin));
        if (ticket.getValue() >= price) {
            if (ticket instanceof PrepaidCard) {
                ((PrepaidCard) ticket).deduct(price);
            }
            return true;
        }
        return false;
    }

}
