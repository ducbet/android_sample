package tmd.javabasic1.b_13_3;

import java.util.Scanner;

/**
 * Created by tmd on 13/03/2017.
 */

public class array_string_class {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        array1D();
//        array2D();
        string();


    }

    private static void string() {
        String str = "HEDSPI";

        System.out.println(str);
        //  HEDSPI

        System.out.printf("length '%d'\n", str.length());
        //  length '6'

        System.out.printf("charAt '%d' is '%c'\n", 3, str.charAt(3));
        //  charAt '3' is 'S'

        System.out.printf("Nối chuỗi '%s' với '%s' thành '%s'\n", "HELLO ", str, "HELLO ".concat(str));
        //  Nối chuỗi 'HELLO ' với 'HEDSPI' thành 'HELLO HEDSPI'

        System.out.println(str);
        //  HEDSPI

        System.out.printf("indexOf '%s'\n", str.indexOf("X"));
        // indexOf '-1'

        str += "E";
        System.out.printf("lastIndexOf '%s' is '%d'\n", str, str.lastIndexOf("E"));
        //  lastIndexOf '6'

        str = "HEDSPI K59";
        System.out.printf("replace: '%s'\n", str.replace("K59", "K60"));
        //  replace: 'HEDSPI K60'

        str = str.replace("K59", "K60");
        System.out.printf("replace: '%s'\n", str.replace("K59", "K61"));
        //  replace: 'HEDSPI K60' // không thay đổi

        System.out.printf("replace: '%s'\n", str.substring(4, 6));
        //  replace: 'PI'   // lấy ký tự 4 và 5


        System.out.printf("trim '%s'\n", ("  asdasd  ads " + "\t").trim());
        //  trim 'asdasd  ads'

        str = ";HEDSPI : K59; ANDROID; 2017;";
        String[] arrayStr = str.split(";");
        System.out.printf("length: '%d'\n", arrayStr.length);
        //  length: '4'
        for (String s : arrayStr) {
            System.out.printf("'%s'\n", s);
        }
    }

    private static void array2D() {
        // Mảng 2 chiều: là mảng 1 chiều mà mỗi ô nhớ là 1 mảng 1 chiều. array2D.length = số hàng

        System.out.print("Nhập row: ");
        int row = scanner.nextInt();
        System.out.print("Nhập column: ");
        int column = scanner.nextInt();
        int[][] array2D = new int[row][column];
        System.out.println("array2D's length: " + array2D.length);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.format("Nhập array2D[%d][%d]: ", i, j);
                array2D[i][j] = scanner.nextInt();

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.format("%d ", array2D[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for (int[] rows : array2D) {// không được trùng tên biến (kể cả ở ngoài for. VD: row thì error)
            for (int item : rows) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    private static void array1D() {
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        int[] arrInt = new int[n];
//        int [] arrInt = new int[]{20, 48, 94};//gán trực tiếp
        arrInt[0] = 1;
        for (int i = 0; i < arrInt.length; i++) {
            System.out.format("Nhập giá trị phần tử thứ %d của mảng: ", i + 1);
            arrInt[i] = scanner.nextInt();
        }
        System.out.format("Mảng: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.format("%d ", arrInt[i]);
        }
        System.out.println();

        //Sắp xếp mảng tăng dần
        for (int i = 0; i < arrInt.length - 1; i++) {
            for (int j = i + 1; j < arrInt.length; j++) {
                if (arrInt[i] > arrInt[j]) {
                    int tmp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = tmp;
                }
            }
        }
        System.out.format("Mảng sau khi sắp xếp: ");
        for (int value : arrInt) {
//            System.out.print(value + "\t");
            System.out.format("%d\t", value);
        }
        System.out.println();
        System.out.format("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.format("%d ", arrInt[i]);
        }
    }
}
