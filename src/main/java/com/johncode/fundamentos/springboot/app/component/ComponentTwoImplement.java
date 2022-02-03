package com.johncode.fundamentos.springboot.app.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void greet() {
        System.out.println("Hola desde ComponentTwoImplement");
    }
}
