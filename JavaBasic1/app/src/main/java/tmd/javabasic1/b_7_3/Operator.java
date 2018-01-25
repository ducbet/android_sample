package tmd.javabasic1.b_7_3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author trieu_000
 */
public class Operator {
    public static void main(String[] args) {
        //1. Gán
        int firstNumber = 10;
        System.out.println(firstNumber);
        firstNumber += 10;
        System.out.println(firstNumber);
        firstNumber++;
        System.out.println(firstNumber);
        System.out.println(++firstNumber);
        System.out.println(firstNumber++);
        System.out.println(firstNumber);
        
        firstNumber *= 3;
        System.out.println(firstNumber);
        firstNumber /= 13;
        System.out.println(firstNumber);
        
        firstNumber %= 7;
        System.out.println(firstNumber);
        
        /*
            Toán tử quan hệ: == != < <= > >=
        */
        firstNumber = 10;
        int secondNumber = firstNumber * 5;
        System.out.println(secondNumber / 5 == firstNumber );// độ ưu tiên của == thấp hơn /
        
        firstNumber = 10;
        if(firstNumber == 10 || firstNumber++ == 10){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        System.out.println(firstNumber);// firstNumber == 10 đúng nên dừng luôn
        
        firstNumber = 10;
        if(firstNumber == 10 | firstNumber++ == 10){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        System.out.println(firstNumber);// firstNumber == 10 đúng nhưng vẫn kiểm tra tất cả các đk vì |
        
        // Toán tử 3 ngôi
        String result;
        result = (21%2==0)?"Số chẵn":"Số lẻ";
        System.out.println(result);
        
        // Ép kiểu dữ liệu
        // Up-casting (auto)
        firstNumber = 10;
        float thirdNumber = firstNumber;
        System.out.println(thirdNumber);
        
        //Down-casting (not auto)
        thirdNumber = 4.3f;
        firstNumber = (int)thirdNumber;
        System.out.println(firstNumber);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
