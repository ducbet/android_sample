package com.kimdung.kimdungtronbo.Rule;

import java.util.Arrays;

/**
 * Created by tmd on 03/05/2017.
 */

public class Charcode {
    public final static String[] phuAmCuoi = {"c", "ng", "nh", "ch", "m", "n", "p", "t", ""};
    public final static String[] notPhuAmCuoi = {"b", "d", "đ", "g", "h", "k", "l", "qu",
            "r", "s", "v", "x", "gh", "gi", "kh", "ph", "q",
            "th", "tr", "ngh", "c", "ng", "nh", "ch", "m",
            "n", "p", "t", ""};
    public final static String[] nguyenAm = {
            "a", "à", "á", "ả", "ã", "ạ",
            "ai", "ài", "ái", "ải", "ãi", "ại",
            "ao", "ào", "áo", "ảo", "ão", "ạo",
            "au", "àu", "áu", "ảu", "ạu",
            "ay", "ày", "áy", "ảy", "ãy", "ạy",
            "ă", "ằ", "ắ", "ẳ", "ẵ", "ặ",
            "â", "ầ", "ấ", "ẩ", "ẫ", "ậ",
            "âu", "ầu", "ấu", "ẩu", "ẫu", "ậu",
            "ây", "ầy", "ấy", "ẩy", "ẫy", "ậy",
            "e", "è", "é", "ẻ", "ẽ", "ẹ",
            "eo", "èo", "éo", "ẻo", "ẽo", "ẹo",
            "ê", "ề", "ế", "ể", "ễ", "ệ",
            "êu", "ều", "ếu", "ểu", "ễu", "ệu",
            "i", "ì", "í", "ỉ", "ĩ", "ị",
            "ia", "ìa", "ía", "ỉa", "ĩa", "ịa", "ià", "iá", "iả", "iã", "iạ",
            "iê", "iề", "iế", "iể", "iễ", "iệ",
            "iu", "ìu", "íu", "ỉu", "ĩu", "ịu",
            "iêu", "iều", "iếu", "iểu", "iễu", "iệu",
            "o", "ò", "ó", "ỏ", "õ", "ọ",
            "oa", "oà", "oá", "oả", "oã", "oạ", "óa", "òa", "ỏa", "õa", "ọa",
            "oai", "oài", "oái", "oải", "oãi", "oại",
            "oay", "oày", "oáy", "oảy", "oãy", "oạy",
            "oă", "oằ", "oắ", "oẳ", "oẵ", "oặ",
            "oe", "òe", "óe", "ỏe", "õe", "ọe", "oè", "oé", "oẻ", "oẽ", "oẹ",
            "oeo", "oéo", "oèo", "oẻo", "oẽo", "oẹo",
            "oi", "òi", "ói", "ỏi", "õi", "ọi",
            "oo", "oò", "oó",
            "ô", "ồ", "ố", "ổ", "ỗ", "ộ",
            "ôi", "ồi", "ối", "ổi", "ỗi", "ội",
            "ơ", "ờ", "ớ", "ở", "ỡ", "ợ",
            "ơi", "ời", "ới", "ởi", "ỡi", "ợi",
            "u", "ù", "ú", "ủ", "ũ", "ụ",
            "ua", "ùa", "úa", "ủa", "ũa", "ụa", "uà", "uá", "uả", "uã", "uạ",
            "uài", "uái", "uải", "uãi", "uại",
            "uay", "uày", "uáy", "uảy", "uãy", "uạy",
            "uâ", "uầ", "uấ", "uẩ", "uẫ", "uậ",
            "uây", "uầy", "uấy", "uẩy", "uẫy", "uậy",
            "ui", "ùi", "úi", "ủi", "ũi", "ụi",
            "uê", "uề", "uế", "uể", "uễ", "uệ",
            "uô", "uồ", "uố", "uổ", "uỗ", "uộ",
            "uôi", "uồi", "uối", "uổi", "uỗi", "uội",
            "uơ", "uớ", "uở",
            "uy", "ùy", "úy", "ủy", "ũy", "ụy", "uý", "uỵ",
            "uya",
            "uyê", "uyề", "uyế", "uyể", "uyễ", "uyệ",
            "uỷu", "uỵu",
            "ư", "ứ", "ừ", "ử", "ữ", "ự",
            "ưa", "ừa", "ứa", "ửa", "ữa", "ựa",
            "ưi", "ừi", "ứi", "ửi", "ữi", "ựi",
            "ươ", "ườ", "ướ", "ưở", "ưỡ", "ượ",
            "ươi", "ười", "ưới", "ưởi", "ưỡi", "ượi",
            "ươu", "ườu", "ượu","ướu","ưỡu","ưởu",
            "ưu", "ừu", "ứu", "ửu", "ữu", "ựu",
            "y", "ỳ", "ý", "ỷ", "ỹ", "ỵ",
            "yê", "yề", "yế", "yể", "yễ", "yệ",
            "yêu", "yều", "yếu", "yểu", ""
    };
    public final static String[] nguyenAmDacBiet = {"e", "è", "é", "ẻ", "ẽ", "ẹ", "ê", "ề", "ế", "ể", "ễ", "ệ", "i", "ì", "í", "ỉ", "ĩ", "ị"};
    public final static String[] nguyenAmDauSacvaNang = {
            "á", "ạ", "ắ", "ặ", "ấ", "ậ",
            "é", "ẹ", "ế", "ệ",
            "í", "ị", "iế", "iệ",
                "ó", "ọ", "oá", "oạ", "óa", "ọa", "oắ", "oặ",
            "óe", "ọe", "oé", "oẹ", "oó", "ố", "ộ",
            "ớ", "ợ",
            "ú", "ụ", "uấ", "uậ", "uế", "uệ", "uố", "uộ", "uớ",
            "uyế", "uyể", "uyễ", "uyệ", "uý", "uỵ",
            "ứ", "ự", "ướ", "ượ",
            "yế", "yệ"
    };

//    private static char CHAR_a = 'a';
//    private static char CHAR_A = 'A';
//    private static char CHAR_z = 'z';
//    private static char CHAR_Z = 'Z';

    public static void sortCharcode() {//
        // cần sortCharcode ngay khi vào chương trình
        Arrays.sort(nguyenAm);
        Arrays.sort(phuAmCuoi);
        Arrays.sort(notPhuAmCuoi);
        Arrays.sort(nguyenAmDacBiet);
    }
}
