package com.johncode.fundamentos.springboot.app.bean;

public class MathOperationsImplement implements MathOperations {
    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double substract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }
}
