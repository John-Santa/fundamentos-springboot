package com.johncode.fundamentos.springboot.app.bean;

public class MyBeanImplement implements MyBean {

    @Override
    public void print() {
        System.out.println("Hola desde MyBeanImplement");
    }
}
