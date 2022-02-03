package com.johncode.fundamentos.springboot.app.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int result = myOperation.sum(1, 2);
        System.out.println("Result: " + result);
        System.out.println("Hola desde MyBeanWithDependencyImplement");
    }
}
