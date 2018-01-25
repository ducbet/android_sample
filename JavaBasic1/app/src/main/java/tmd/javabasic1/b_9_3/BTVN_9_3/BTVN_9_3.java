/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmd.javabasic1.b_9_3.BTVN_9_3;

import java.util.Scanner;

/**
 *
 * @author trieu_000
 */

/*
    Tạo class nhân viên, kiểm tra xem nhân viên có sinh vào năm nhuận hay không?
 */
public class BTVN_9_3 {

    public static void main(String[] args) {

        System.out.println("Nhập tên nhân viên cần kiểm tra: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String lastName = scanner.nextLine();
        System.out.print("Nhập họ: ");
        String firstName = scanner.nextLine();
        System.out.print("Nhập giới tính (0: nam; 1: nữ): ");
        int gender = scanner.nextInt();
        System.out.print("Nhập năm sinh: ");
        int dateOfBirth = scanner.nextInt();
        

        // tạo đối tượng để lưu 
        Employee employee = new Employee();
        employee.setmDateOfBirth(dateOfBirth);
        employee.setmFirstName(firstName);
        employee.setmLastName(lastName);
        employee.setmGender(gender);

        // in thông tin nhân viên // override hàm toString
        System.out.println(employee.toString());

        //
        if (employee.isLeapYear()) {
            System.out.println("Nhân viên sinh năm nhuận");

        } else {
            System.out.println("Nhân viên không sinh năm nhuận");
        }
    }
}


