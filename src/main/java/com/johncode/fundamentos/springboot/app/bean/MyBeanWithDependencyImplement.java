package com.johncode.fundamentos.springboot.app.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Ingresando al método printWithDependency");
        int result = myOperation.sum(1, 2);
        LOGGER.debug("Resultado de la suma: " + result);
        System.out.println("Result: " + result);
        System.out.println("Hola desde MyBeanWithDependencyImplement");
    }
}
