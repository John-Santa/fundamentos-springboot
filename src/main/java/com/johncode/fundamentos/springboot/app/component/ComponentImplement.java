package com.johncode.fundamentos.springboot.app.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void greet() {
        System.out.println("Hello from ComponentImplement");
    }

}
