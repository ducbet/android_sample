package tmd.javabasic1.b_13_3.BTVN_13_3;

import java.util.Scanner;
import java.math.*;

/**
 * Created by tmd on 13/03/2017.
 */

/*
    a. Nhập  n từ bàn phím;
    b. Tính tích của dãy 1->n
    c. Kiểm tra tính nguyên tố của 1 số
    d. In ra số nguyên tố thứ n
*/

public class BTVN_13_3 {
    public static void main(String[] args) {
        System.out.print("Nhập n: ");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n.intValue(); i++) {
            sum += i;
        }
        System.out.println("sum 1->" + n + " = " + sum);

        int uoc = 0;
        int i = 2;
        for (; i < n; i++) {
            if (n % i == 0) {
                uoc++;
                break;
            }
        }
        if (uoc == 0){
            System.out.println(n + " là số nguyên tố");
        }

            else
        {
            System.out.println(n + " không là số nguyên tố vì chia hết cho " + i);
        }
    }
}
