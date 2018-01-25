package com.example.tmd.observer_designpattern;

/**
 * Created by tmd on 07/04/2017.
 */

public interface Subject {
    // interface chứa những phương thức nhằm liên lạc với bất kỳ subject nào

    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    //method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(Observer obj);
}
