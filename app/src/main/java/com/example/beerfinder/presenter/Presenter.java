package com.example.beerfinder.presenter;

public abstract class Presenter<T> {

    T view;

    public void attachScreen(T view){
        this.view = view;
    }

    public void detachScreen(){
        this.view = null;
    }

}
