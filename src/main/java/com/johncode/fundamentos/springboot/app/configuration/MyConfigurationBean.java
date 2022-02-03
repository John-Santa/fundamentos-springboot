package com.johncode.fundamentos.springboot.app.configuration;
import com.johncode.fundamentos.springboot.app.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation() {
        return new MyBeanTwoImplement();
    }

    @Bean
    public MyOperation beanSumOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanWitDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MathOperations beanByMathOperations() {
        return new MathOperationsImplement();
    }
}
