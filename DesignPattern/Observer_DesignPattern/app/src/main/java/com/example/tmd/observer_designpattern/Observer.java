package com.example.tmd.observer_designpattern;

/**
 * Created by tmd on 07/04/2017.
 */

public interface Observer {
    // chứa method cập nhật trạng thái và truyền subject khi lắng nghe sự thay đổi


    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}
