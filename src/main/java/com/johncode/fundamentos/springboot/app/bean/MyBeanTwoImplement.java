package com.johncode.fundamentos.springboot.app.bean;

public class MyBeanTwoImplement implements MyBean {

    @Override
    public void print() {
        System.out.println("Hola desde MyBeanTwoImplement");
    }
}
