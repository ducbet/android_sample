package tmd.javabasic1.b_13_3;

import java.util.Scanner;

/**
 * Created by tmd on 13/03/2017.
 */

public class drawGiDo {

    public static void main(String[] args) {
        int n = 5; // bắt đầu từ n = 5 mới ra hình
        while (n > 4) {
            System.out.print("Nhập n: ");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();

            for (int doc = 0; doc < n; doc++) {
                for (int ngang = 0; ngang < n; ngang++) {
                    System.out.print(" ");
                    if (doc == ngang) System.out.print("*");
                    else if (doc + ngang == n - 1) System.out.print("*");
                    else if (doc == 0 || doc == n - 1) System.out.print("*");
                    else if (ngang == 0 || ngang == n - 1) System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.println();
            }
        }

    }
}
