package com.kimdung.kimdungtronbo.Rule;

import static com.kimdung.kimdungtronbo.Rule.Charcode.nguyenAm;
import static com.kimdung.kimdungtronbo.Rule.Charcode.nguyenAmDacBiet;
import static com.kimdung.kimdungtronbo.Rule.Charcode.notPhuAmCuoi;
import static com.kimdung.kimdungtronbo.Rule.Charcode.phuAmCuoi;

public class Xau {

    private String xau;
    private String phu_am_dau;
    private String nguyen_am;
    private String phu_am_cuoi;
    private int so_nguyen_am;
    private int so_phu_am;

    public Xau(String xau) {
        int i = 0;
        ///xử lý khi xâu đi liền với dấu
        //loai bo cac ky tu dau xau la cac dau " (
        while ((xau.charAt(i) == '"') || (xau.charAt(i) == '(') || (xau.charAt(i) == '\t')) {
            xau = xau.substring(0, i) + xau.substring(i + 1);
            if (xau.length() == 0) break;
        }
//        loai bo cac ky tu cuoi xau la cac dau !"#$%&'()*+,-./0123456789:;<=>?@[\]^_`
        i = xau.length() - 1;
        if (i >= 0) {
            while (((64 >= xau.charAt(i)) && (xau.charAt(i)) >= 32) || ((96 >= xau.charAt(i)) && (xau.charAt(i)) >= 91)) {
                xau = xau.substring(0, i);
                i--;
                if (i == -1) break;
            }
        }
        this.xau = xau.toLowerCase();// toLowerCase() o paragraph
    }

    private void setXau(String s1, String s2, String s3, int i1, int i2) {
        phu_am_dau = s1;
        nguyen_am = s2;
        phu_am_cuoi = s3;
        so_nguyen_am = i1;
        so_phu_am = i2;
    }

    private boolean binSearch(String x, String[] array) {
        int first = 0;
        int last = array.length;
        while (first < last) {
            int mid = (first + last) / 2;
            if (x.compareTo(array[mid]) < 0) last = mid;
            else {
                if (x.compareTo(array[mid]) > 0) first = mid + 1;
                else {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean isNguyenAm(String x) {
        return binSearch(x, nguyenAm);
    }

    public boolean isPhuAm(String x) {
        if (binSearch(x, notPhuAmCuoi) != true)
            return (binSearch(x, phuAmCuoi));
        return true;
    }

    private boolean isPhuAmCuoi(String x) {
        return (binSearch(x, phuAmCuoi));
    }

    public boolean isNguyenAmDacBiet(String x) {
        return (binSearch(x, nguyenAmDacBiet));
    }

    public boolean tachXau() {
        String tmpPAD = "", tmpNA = "", tmpPAC = "";
        int i;
        //lay phu am dau
        for (i = 0; i < xau.length(); i++) {
            String tmp = String.valueOf(xau.charAt(i));
            if (i == 1) {
                if ((xau.charAt(0) == 'g') && (xau.charAt(1) == 'i')) {
                    tmpPAD = tmpPAD.concat(tmp);
                }
            }
            if (i == 1) {
                if ((xau.charAt(0) == 'q') && (xau.charAt(1) == 'u')) {
                    tmpPAD = tmpPAD.concat(tmp);
                }
            }
            if (isPhuAm(tmp) == true) {
                tmpPAD = tmpPAD.concat(tmp);
                so_phu_am++;
            } else break;

        }
        if (isPhuAm(tmpPAD) != true) return false;
        //System.out.println("p.a.ok="+tmpPAD+tmpPAD.length());
        //------------------------------------------------------------------------------
        //lay nguyen am
        for (i = tmpPAD.length(); i < xau.length(); i++) {
            String tmp = String.valueOf(xau.charAt(i));
            if (isNguyenAm(tmp) == true) {
                tmpNA = tmpNA.concat(tmp);
                so_nguyen_am++;
            } else break;
        }
        if (isNguyenAm(tmpNA) != true) return false;
        //System.out.println("n.a.ok="+tmpNA+so_nguyen_am);
        //------------------------------------------------------------------------------
        //lay phu am cuoi
        for (i = tmpPAD.length() + tmpNA.length(); i < xau.length(); i++) {
            String tmp = String.valueOf(xau.charAt(i));
            if (isPhuAm(tmp) == true) {
                tmpPAC = tmpPAC.concat(tmp);
                so_phu_am++;
            } else break;
        }
        if (isPhuAmCuoi(tmpPAC) != true) return false;
        //System.out.println("p.a.ok="+tmpPAC+so_phu_am);
        //------------------------------------------------------------------------------
        if (i < xau.length()) return false;
        if ((tmpPAD.compareTo("") != 0) && (tmpNA.compareTo("") == 0))
            return false; //neu co phu am ma khong co nguyen am thi sai
        setXau(tmpPAD, tmpNA, tmpPAC, so_nguyen_am, so_phu_am);
        return true;
    }

    public String getXau() {
        return xau;
    }

    public String getPhu_am_dau() {
        return phu_am_dau;
    }

    public String getNguyen_am() {
        return nguyen_am;
    }

    public String getPhu_am_cuoi() {
        return phu_am_cuoi;
    }

    public int getSo_nguyen_am() {
        return so_nguyen_am;
    }

    public int getSo_phu_am() {
        return so_phu_am;
    }
}
