package com.example.demo.controller;

public class Model<T>{

    private T generico;

	public T getGenerico(){
        return generico;
    }

    public void setGenerico(T entrada){
        this.generico = entrada;
    }
}