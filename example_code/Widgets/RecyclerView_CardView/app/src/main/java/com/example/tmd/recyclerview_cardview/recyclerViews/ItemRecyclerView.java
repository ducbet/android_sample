package com.example.tmd.recyclerview_cardview.recyclerViews;

/**
 * Created by tmd on 24/03/2017.
 */

public class ItemRecyclerView{
        int mImage;

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getNameApp() {
        return mNameApp;
    }

    public void setNameApp(String nameApp) {
        mNameApp = nameApp;
    }

    public ItemRecyclerView(int image, String nameApp) {

        mImage = image;
        mNameApp = nameApp;
    }

    private String mNameApp;

}
