package tmd.javabasic1.b_14_3.BTVN_14_3;

/**
 * Created by tmd on 14/03/2017.
 */

public class BTVN_14_3 {

    /*
        - nhập vào xâu str từ bàn phím, kiểm tra xem trong xâu có bao nhiêu chữ a
        - Kiểm tra xem xâu có bao nhiêu từ
        - Nhập vào tên của một người, kiểm tra Họ của người đó có phải là Doan ko
        - Xóa các kí tự space đầu và cuối trong 1 xâu, giữa các từ trong xâu chỉ có 1 space.
    */

    public static void main(String[] args) {
        String str = " Doan dzxc awa   asixioj dasd   ";
        int i, a;

        for (a = 0, i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a++;
            }
        }
        System.out.println("Xau '" + str + "'" + " có " + a + " ký tự 'a'");

        String newStr = "";
        String[] splitStr = str.split(" ");

        for (String s : splitStr) {
            if (s.equals("") == false) {
                newStr += s;
                newStr += " ";
            }
        }
        newStr = newStr.trim();
        System.out.printf("'%s'\n", newStr);
        System.out.printf("xau '%s' co %d tu\n", str, newStr.split(" ").length);

        splitStr = newStr.split(" ");
        if (splitStr[0].equals("Doan")) {
            System.out.println("Ho cua nguoi nhap vao la 'Doan'");
        } else {
            System.out.println("Ho cua nguoi nhap vao khong phai la 'Doan'");
        }
    }
}
