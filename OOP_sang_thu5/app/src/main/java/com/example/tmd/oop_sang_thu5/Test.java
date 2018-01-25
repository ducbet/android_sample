package com.example.tmd.oop_sang_thu5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tmd on 20/04/2017.
 */

public class Test {

    public static Calendar calendar = Calendar.getInstance();
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static final Date today = calendar.getTime();
    public static Date yesterday;

    public static void main(String[] args) {

        calendar.set(2017, 04, 19);
        yesterday = calendar.getTime();
        System.out.println("Yesterday: " + sdf.format(yesterday));
        System.out.println("Today: " + sdf.format(today));

        OneWayTicket oneWayTicket;
        PrepaidCard prepaidCard;

        // ve khong hop le
        System.out.println("\nOneWayTicket A->C:");
        oneWayTicket = new OneWayTicket(yesterday,
                Line.getFare(Line.gateC.getDistance() - Line.gateA.getDistance()));
        Line.gateA.enter(oneWayTicket);
        Line.gateC.exit(oneWayTicket);

        // ve khong khong du tien
        System.out.println("\nOneWayTicket A->C:");
        oneWayTicket = new OneWayTicket(today,
                Line.getFare(Line.gateC.getDistance() - Line.gateA.getDistance()) - 1000);
        Line.gateA.enter(oneWayTicket);
        Line.gateC.exit(oneWayTicket);

        // su dung duoc ve
        System.out.println("\nOneWayTicket A->C:");
        oneWayTicket = new OneWayTicket(today,
                Line.getFare(Line.gateC.getDistance() - Line.gateA.getDistance()));
        Line.gateA.enter(oneWayTicket);
        Line.gateC.exit(oneWayTicket);

        System.out.println("****************************************************");

        // the khong hop le
        System.out.println("\nPrepaidCard A->C:");
        prepaidCard = new PrepaidCard(today, 2000);
        Line.gateA.enter(prepaidCard);
        Line.gateC.exit(prepaidCard);

        // su dung duoc ve
        // di nhieu lan, deduct lien tuc -> het tien
        // the khong khong du tien
        System.out.println("\nPrepaidCard A->C:");
        prepaidCard = new PrepaidCard(yesterday, 50000);
        System.out.println("Card have " + prepaidCard.getValue() + " VND");
        Line.gateA.enter(prepaidCard);
        Line.gateC.exit(prepaidCard);
        System.out.println("Card have " + prepaidCard.getValue() + " VND");

        System.out.println("\nPrepaidCard C->D:");
        System.out.println("Card have " + prepaidCard.getValue() + " VND");
        Line.gateC.enter(prepaidCard);
        Line.gateD.exit(prepaidCard);
        System.out.println("Card have " + prepaidCard.getValue() + " VND");

        System.out.println("\nPrepaidCard D->A:");
        System.out.println("Card have " + prepaidCard.getValue() + " VND");
        Line.gateD.enter(prepaidCard);
        Line.gateA.exit(prepaidCard);
        System.out.println("Card have " + prepaidCard.getValue() + " VND");
    }
}
