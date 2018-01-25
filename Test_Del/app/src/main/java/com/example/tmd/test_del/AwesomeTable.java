package com.example.tmd.test_del;

import static com.example.tmd.test_del.MainActivity.TABLE_2_PERSON;
import static com.example.tmd.test_del.MainActivity.TABLE_2_PERSON_IMAGE;
import static com.example.tmd.test_del.MainActivity.TABLE_2_PERSON_SIZE;
import static com.example.tmd.test_del.MainActivity.TABLE_4_PERSON;
import static com.example.tmd.test_del.MainActivity.TABLE_4_PERSON_IMAGE;
import static com.example.tmd.test_del.MainActivity.TABLE_4_PERSON_SIZE;
import static com.example.tmd.test_del.MainActivity.TABLE_8_PERSON;
import static com.example.tmd.test_del.MainActivity.TABLE_8_PERSON_IMAGE;
import static com.example.tmd.test_del.MainActivity.TABLE_8_PERSON_SIZE;

/**
 * Created by tmd on 23/08/2017.
 */
public class AwesomeTable {
    private int mX;
    private int mY;
    private int width;
    private int height;
    private String mTableType;
    private int mImage;

    public AwesomeTable(int x, int y, String tableType) {
        mX = x;
        mY = y;
        mTableType = tableType;
        switch (tableType) {
            case TABLE_2_PERSON:
                this.width = TABLE_2_PERSON_SIZE[0];
                this.height = TABLE_2_PERSON_SIZE[1];
                mImage = TABLE_2_PERSON_IMAGE;
                break;
            case TABLE_4_PERSON:
                this.width = TABLE_4_PERSON_SIZE[0];
                this.height = TABLE_4_PERSON_SIZE[1];
                mImage = TABLE_4_PERSON_IMAGE;
                break;
            case TABLE_8_PERSON:
                this.width = TABLE_8_PERSON_SIZE[0];
                this.height = TABLE_8_PERSON_SIZE[1];
                mImage = TABLE_8_PERSON_IMAGE;
                break;
            default:
                break;
        }
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getTableType() {
        return mTableType;
    }
}