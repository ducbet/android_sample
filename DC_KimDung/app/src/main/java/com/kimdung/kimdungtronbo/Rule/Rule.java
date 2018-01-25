package com.kimdung.kimdungtronbo.Rule;

import static com.kimdung.kimdungtronbo.Rule.Charcode.nguyenAmDauSacvaNang;


public class Rule {
    public static boolean checkValidToken(Xau x) {
        if (checkDoDai(x) == false) return false;    //kiem tra do dai phai <=7
        if (checkCauTruc(x) == false) return false;    //kiem tra cau truc p-n-p hop ly khong
        if (checkPhuAmDacBiet(x) == false)
            return false;    //kiem tra nguyen am di kem voi gh,ngh va g,ng,c
        if (checkPhuAmQ(x) == false) return false;    //kiem tra sau q phai la u
        if (checkPhuAmK(x) == false)
            return false;    //kiem tra sau k phai la nguyen am dac biet hoac y
        if (checkNguyenAmDai(x) == false)
            return false;    //nguyen am dai 3 (trừ "uyê") hoac nguyen am dai 2 duoi i,o,u,y (trừ uy,oo) khong duoc co phu am cuoi
        if (checkNguyenAmNgan(x) == false) return false;    // nguyen am ă va â phai co phu am cuoi
        if (checkPhuAmNgat(x) == false)
            return false;    //kiem tra nguyen am khi phu am cuoi la c, ch, p, t
        return true;
    }

    private static boolean checkCauTruc(Xau x) {
        return x.tachXau();
    }

    private static boolean checkDoDai(Xau x) {
        if (x.getXau().length() > 7) return false;
        return true;
    }

    private static boolean checkPhuAmDacBiet(Xau x) {
        if ((x.getPhu_am_dau().compareTo("gh") == 0) || (x.getPhu_am_dau().compareTo("ngh") == 0)) {
            String tmp = String.valueOf(x.getXau().charAt(x.getPhu_am_dau().length()));
            return (x.isNguyenAmDacBiet(tmp));
        }
        if ((x.getPhu_am_dau().compareTo("g") == 0) || (x.getPhu_am_dau().compareTo("ng") == 0)
                || (x.getPhu_am_dau().compareTo("c") == 0)) {
            String tmp = String.valueOf(x.getXau().charAt(x.getPhu_am_dau().length()));
            if (x.getPhu_am_dau().compareTo("g") == 0) { //rieng g co the dung truoc i
                if ("iìíỉĩị".contains(tmp)) return true;
            }
            return (!x.isNguyenAmDacBiet(tmp));
        }
        return true;
    }

    private static boolean checkPhuAmK(Xau x) {
        if (x.getPhu_am_dau().compareTo("k") == 0) {
            String tmp = String.valueOf(x.getXau().charAt(1));
            if ((x.isNguyenAmDacBiet(tmp) == false) && !("yỳýỷỹỵ".contains(tmp)))
                return false;
        }
        return true;
    }

    private static boolean checkPhuAmQ(Xau x) {
        if (x.getPhu_am_dau().compareTo("q") == 0) {
            String tmp = String.valueOf(x.getXau().charAt(1));
            if (!"uùúủũụ".contains(tmp))
                return false;//qt
            if (x.getXau().length() == 2) return false;// chỉ có "qu"
            if (x.isPhuAm(String.valueOf(x.getXau().charAt(2))) == true) return false;// qut
        }
        return true;
    }

    private static boolean checkNguyenAmDai(Xau x) {
        if (x.getSo_nguyen_am() == 3) {
            if ((x.getNguyen_am().compareTo("uyê") != 0) && (x.getNguyen_am().compareTo("uyề") != 0) &&
                    (x.getNguyen_am().compareTo("uyế") != 0) && (x.getNguyen_am().compareTo("uyể") != 0) &&
                    (x.getNguyen_am().compareTo("uyễ") != 0) && (x.getNguyen_am().compareTo("uyệ") != 0)) {
                if (x.getPhu_am_cuoi().compareTo("") != 0) return false;
            }
        }
        if (x.getSo_nguyen_am() == 2) {
            if ((x.getNguyen_am().charAt(1) == 'i') || (x.getNguyen_am().charAt(1) == 'o') || (x.getNguyen_am().charAt(1) == 'y') || (x.getNguyen_am().charAt(1) == 'u'))
                if ((x.getNguyen_am().compareTo("uy") != 0) && (x.getNguyen_am().compareTo("ùy") != 0) &&
                        (x.getNguyen_am().compareTo("úy") != 0) && (x.getNguyen_am().compareTo("ủy") != 0) &&
                        (x.getNguyen_am().compareTo("ũy") != 0) && (x.getNguyen_am().compareTo("ụy") != 0) && (x.getNguyen_am().compareTo("oo") != 0))
                    if (x.getPhu_am_cuoi().compareTo("") != 0) return false;
        }
        return true;
    }

    private static boolean checkNguyenAmNgan(Xau x) {
        if (x.getNguyen_am().length() == 1) {
            if ("ăắằẳẵặâấầẩẫậ".contains(x.getNguyen_am()) == true) {
                if (x.getPhu_am_cuoi().equals("")) return false;
            }
        }
        return true;
    }

    private static boolean checkPhuAmNgat(Xau x) {
        if ((x.getPhu_am_cuoi().compareTo("c") == 0) || (x.getPhu_am_cuoi().compareTo("ch") == 0) || (x.getPhu_am_cuoi().compareTo("p") == 0) || (x.getPhu_am_cuoi().compareTo("t") == 0)) {
            for (int i = 0; i < nguyenAmDauSacvaNang.length; i++) {
                if (x.getNguyen_am().equals(nguyenAmDauSacvaNang[i])) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

}
