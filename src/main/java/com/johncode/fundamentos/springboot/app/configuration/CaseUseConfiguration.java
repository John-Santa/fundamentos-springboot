package com.johncode.fundamentos.springboot.app.configuration;

import com.johncode.fundamentos.springboot.app.caseuse.GetUser;
import com.johncode.fundamentos.springboot.app.caseuse.GetUserImpl;
import com.johncode.fundamentos.springboot.app.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}
