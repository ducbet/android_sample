package com.example.tmd.displayhtmlintextview.KimDung;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tmd on 22/04/2017.
 */

public class VietNamese_Chars {
    public static final int MIN_NGUYEN_AM = 1;
    public static final int MAX_NGUYEN_AM = 3;
    public static final int MIN_PHU_AM = 0;
    public static final int MAX_PHU_AM = 5;

    public static final List<Character> VIETNAMESE_ALL_CHAR = new ArrayList<Character>(Arrays.asList(
            'a', 'à', 'á', 'ả', 'ã', 'ạ',
            'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ',
            'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
            'b',
            'c',
            'd',
            'đ',
            'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ',
            'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ',
            'g',
            'h',
            'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị',
            'k',
            'l',
            'm',
            'n',
            'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ',
            'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ',
            'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
            'p',
            'q',
            'r',
            's',
            't',
            'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ',
            'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự',
            'v',
            'x',
            'y', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'
    ));

    public static final List<Character> VIETNAMESE_PHU_AM_CHAR = new ArrayList<Character>(Arrays.asList(
            'b',
            'c',
            'd',
            'đ',
            'g',
            'h',
            'k',
            'l',
            'm',
            'n',
            'p',
            'q',
            'r',
            's',
            't',
            'v',
            'x'
    ));

    public static final List<Character> VIETNAMESE_PHU_AM_CUOI_CHAR = new ArrayList<Character>(Arrays.asList(
            'c',
            'g',
            'h',
            'm',
            'n',
            'p',
            't'
    ));
}