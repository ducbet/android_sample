package com.example.tmd.javatest;

/**
 * Created by tmd on 10/03/2017.
 */

public class math {
    public static void main(String[] args) {
        int n = 25;
        System.out.println("Căn bậc 2 của " + n + " = " + Math.sqrt(n));

        int m = 2;
        System.out.println(n + " ^ " + m + " = " + Math.pow(n, m));

        int j = -4;
        System.out.println("|" + j + "|" + " = " + Math.abs(j));

        int banKinh = 5;
        double chuVi = Math.PI*2*banKinh;
        double dienTich = Math.PI*Math.pow(banKinh, 2);
        System.out.format("%s%d%s%.2f\n", "Chu vi của hình tròn có bán kính ",banKinh, " là: ", chuVi);
        System.out.format("%s%d%s%.2f\n", "Diện tích của hình tròn có bán kính ", banKinh, " là: ", dienTich);

        int goc = 55;
        double rad = Math.PI*goc/180;
        System.out.format("sin cua goc %d = %.2f\n", goc, Math.sin(rad));
        System.out.format("cos cua goc %d = %.2f\n", goc, Math.cos(rad));
        System.out.format("tan cua goc %d = %.2f\n", goc, Math.tan(rad));
        System.out.format("cotan cua goc %d = %.2f\n", goc, 1/Math.tan(rad));

    }
}
