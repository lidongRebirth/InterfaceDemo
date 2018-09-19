package com.example.administrator.myapplication;

/**
 * Presenter层，通过调用Model层方法来实现自己的方法供View(Activity)调用
 */
public class Presenter {

    private  Model a = new Model();

    public void getData(){
        a.getData();
    }

}
