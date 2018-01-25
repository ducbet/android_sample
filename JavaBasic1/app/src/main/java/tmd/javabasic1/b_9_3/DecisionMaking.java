/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmd.javabasic1.b_9_3;

/**
 *
 * @author trieu_000
 */

/*
    Cho 1 số nguyên nhập từ bàn phím n, 0<n<13
    In ra mùa của tháng hiện tại
 */
public class DecisionMaking {

    public static void main(String[] args) {
        int n = 7;
        if (1 <= n && n <= 3) {
            System.out.println("Mùa xuân");
        } else if (4 <= n & n <= 6) {
            System.out.println("Mùa hạ");
        } else if (7 <= n & n <= 9) {
            System.out.println("Mùa thu");
        } else if (10 <= n & n <= 12) {
            System.out.println("Mùa đông");
        } else {
            System.out.println("Không phải mùa trong năm");
        }

        switch (n) {
            case 1:
            case 2:
            case 3:
                System.out.println("Mùa xuân");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Mùa hạ");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Mùa thu");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Mùa đông");
                break;
            default:
                System.out.println("Không phải mùa trong năm");
            //break;

        }
        for (int m = 0, sum = 0; m <= 100; m++, sum += m) {
            System.out.println(sum);
        }
    }
}
