package com.johncode.fundamentos.springboot.app;

import com.johncode.fundamentos.springboot.app.bean.MathOperations;
import com.johncode.fundamentos.springboot.app.bean.MyBean;
import com.johncode.fundamentos.springboot.app.bean.MyBeanWithDependency;
import com.johncode.fundamentos.springboot.app.bean.MyBeanWithProperties;
import com.johncode.fundamentos.springboot.app.component.ComponentDependency;
import com.johncode.fundamentos.springboot.app.entity.User;
import com.johncode.fundamentos.springboot.app.pojo.UserPojo;
import com.johncode.fundamentos.springboot.app.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MathOperations mathOperations;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
                                  MyBean myBean,
                                  MyBeanWithDependency myBeanWithDependency,
                                  MathOperations mathOperations,
                                  MyBeanWithProperties myBeanWithProperties,
                                  UserPojo userPojo,
                                  UserRepository userRepository
    ) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.mathOperations = mathOperations;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //previousCode();
        saveUsersInDB();
        getInformationJpqlFromUser();
    }

    private void previousCode() {
        componentDependency.greet();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        System.out.println(mathOperations.substract(10D, 5D));
        String fullname = myBeanWithProperties.printFullName();
        System.out.println(fullname);
        System.out.println(userPojo.getEmail());
        try {
            int value = 10 / 0;
            LOGGER.debug("Value: " + value);
        }catch (Exception e){
            LOGGER.error("Error al dividir por cero", e);
        }
    }

    private void saveUsersInDB() {
        User john = new User("John", "john@domain.com", LocalDate.of(1996,01,31));
        User jane = new User("Jane", "jane@domain.com", LocalDate.of(1996,02,01));
        User jose = new User("Jose", "jose@domail.com", LocalDate.of(1996,03,01));
        User joseph = new User("Joseph", "joseph@gmail.com", LocalDate.of(1996,04,01));
        User josephine = new User("Josephine", "josephine@gmail.com", LocalDate.of(1996,05,01));
        User nohelia = new User("Nohelia", "nohelia@gmail.com", LocalDate.of(1996,06,01));

        List<User> users = List.of(john, jane, jose, joseph, josephine, nohelia);
        users.stream().forEach(userRepository::save);
    }

    private void getInformationJpqlFromUser(){
        userRepository.findByEmail("john@domain.com")
                .ifPresent(user -> LOGGER.info("User with method userRepository.findByEmail(john@domain.com)" + user.toString()));

        userRepository.findAndSortByName("Jo", Sort.by("id").descending())
                .stream()
                .forEach(user -> LOGGER.info("User with method userRepository.findAndSortByName(Jo, Sort.by(\"id\").descending())" + user.toString()));
    }
}
