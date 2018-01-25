package tmd.javabasic1;

/**
 * Created by trieu_000 on 3/7/2017.
 */

public class JavaBasic1 {

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

        int a = 10;

        System.out.println("Hello world!!!");


    }
}
