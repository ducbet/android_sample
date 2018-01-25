package com.example.tmd.datepickerdialog_timepickerdialog;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTimePractice {

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
            System.out.println("----------");
            calendar.set(1996, 8, 25); // 25/09/1996
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(calendar.getTime()));

                sdf = new SimpleDateFormat("MMM dd h:mma");
            System.out.println(sdf.format(calendar.getTime()));
        }
    }

}
