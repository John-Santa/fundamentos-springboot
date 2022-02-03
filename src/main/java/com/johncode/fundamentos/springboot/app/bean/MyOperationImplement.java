package com.johncode.fundamentos.springboot.app.bean;

public class MyOperationImplement implements MyOperation {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
