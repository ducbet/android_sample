/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmd.javabasic1.b_9_3.BTVN_9_3;

/**
 *
 * @author trieu_000
 */
public class Employee {

    private String mLastName;
    private String mFirstName;
    private int mDateOfBirth;
    private int mGender;

    public boolean isLeapYear() {
        return (mDateOfBirth % 4 == 0 && mDateOfBirth % 100 != 0) || mDateOfBirth % 400 == 0;
    }

    public int age(){
        return 2017 - mDateOfBirth;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "mLastName=" + mLastName + ", mFirstName=" + mFirstName + ", mDateOfBirth=" + mDateOfBirth + ", mGender=" + mGender + '}';
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmDateOfBirth(int mDateOfBirth) {
        this.mDateOfBirth = mDateOfBirth;
    }

    public int getmDateOfBirth() {
        return mDateOfBirth;
    }

    public int getmGender() {
        return mGender;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmGender(int mGender) {
        this.mGender = mGender;
    }

}
