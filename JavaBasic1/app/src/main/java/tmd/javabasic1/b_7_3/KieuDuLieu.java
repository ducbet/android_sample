package tmd.javabasic1.b_7_3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author trieu_000
 */
public class KieuDuLieu {

    /*
    * Khai báo biến gồm 3 thành phần
    * 0. access modifier
    *   - private: truy xuất trong cùng 1 lớp
    *   - protected: truy xuất trong chính nó, trong class con
    *   - default: truy xuất trong package
    *   - public: truy xuất mọi nơi
    *
    * 1. Kiểu dữ liệu
    *   - int
    *   - char
    *   - float
    *   - double
    *   - long
    *   - String
    *   - Object
    *
    * 2. Tên biến
    *   - Chứa các chữ cái, chữ số, dấu gạch dưới _ , ký tự $
    *   - Bắt đầu bằng chữ cái, _ $ (không bắt đầu bằng chữ số)
    *   - Không trùng với từ khóa
    *   - Dễ gợi nhớ
    *   - Convention framgia
    *       + non-public start with m
    *   - Biến instance hay (instance variable) // biến được khai báo ngoài method, dùng toàn bộ trong class
    * */

    // format code: Ctrl + Alt + L

    private int mAge = 10; // biến non-public bắt đầu = m
    private int mDateOfBirth = 1996;
    public String name;

    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        int firstNumber = 65;
        int secondNumber = 20;
        
        System.out.println("Số thứ nhất: " + firstNumber);
        System.out.println("Số thứ hai: " + secondNumber );
        
        //----------------------------------------------------------------------
        
        /* Sử dụng format để định dạng dữ liệu đầu ra
            - %n = \n
            - %s in String
        
        */
        
        float thirdNumber = 3.458f;
        String name = "HEDSPI";
        
        System.out.format("Số thứ nhất: %c%n", firstNumber);
        System.out.format("Số thứ ba: %.2f%n", thirdNumber);
        System.out.format("Tên lớp học: %s%n", name);
        
        //----------------------------------------------------------------------
        /*
            Cho số nguyên n nhập vào từ bàn phím, tính tổng n và n - 1
        
        */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Xin mời nhập n: ");
        int n = scanner.nextInt();
        System.out.println(n + " + " + (n-1) + " = " + (n + n-1));
    }
    
}








