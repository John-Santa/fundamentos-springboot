package com.johncode.fundamentos.springboot.app;

import com.johncode.fundamentos.springboot.app.bean.MathOperations;
import com.johncode.fundamentos.springboot.app.bean.MyBean;
import com.johncode.fundamentos.springboot.app.bean.MyBeanWithDependency;
import com.johncode.fundamentos.springboot.app.bean.MyBeanWithProperties;
import com.johncode.fundamentos.springboot.app.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MathOperations mathOperations;
    private MyBeanWithProperties myBeanWithProperties;

    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
                                  MyBean myBean,
                                  MyBeanWithDependency myBeanWithDependency,
                                  MathOperations mathOperations,
                                  MyBeanWithProperties myBeanWithProperties) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.mathOperations = mathOperations;
        this.myBeanWithProperties = myBeanWithProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.greet();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        System.out.println(mathOperations.substract(10D, 5D));
        String fullname = myBeanWithProperties.printFullName();
        System.out.println(fullname);
    }
}
