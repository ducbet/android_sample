package com.example.tmd.javatest;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tmd on 10/03/2017.
 */

public class calendar_simpleDateFormat {

    /*
            - C1: Dùng Date


            - C2: Dùng Calendar

    */

    public static void main(String[] args) {
        // C1:
        {
            Date date = new Date();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(date));

            sdf = new SimpleDateFormat("d/M/yyyy H:m:s");
            System.out.println(sdf.format(date));

            sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            System.out.println(sdf.format(date));
        }

        System.out.println("---------------------------------------");
        // C2:
        {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(calendar.getTime()));
            sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            System.out.println(sdf.format(calendar.getTime()));
            int year = calendar.get(Calendar.YEAR);
            System.out.println(year);
            int month = calendar.get(Calendar.MONTH);
            System.out.println(month);
            int miliSecond = calendar.get(Calendar.MILLISECOND);
            System.out.println(miliSecond);

        }
        System.out.println("---------------------------------------");


        double db = 10.0 / 3;
        double db2 = 10.0;
        System.out.println(db);
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println(df.format(db));
        System.out.format("%.3f", db2);
    }

}
