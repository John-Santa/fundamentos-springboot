package com.johncode.fundamentos.springboot.app.configuration;

import com.johncode.fundamentos.springboot.app.bean.MyBeanWithProperties;
import com.johncode.fundamentos.springboot.app.bean.MyBeanWithPropertiesImplement;
import com.johncode.fundamentos.springboot.app.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties printFullName() {
        return new MyBeanWithPropertiesImplement(name, lastname);
    }
}
