package com.johncode.fundamentos.springboot.app.service;

import com.johncode.fundamentos.springboot.app.entity.User;
import com.johncode.fundamentos.springboot.app.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private static final Log LOGGER = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @Transactional
     * nos permite que todas las operaciones que se realicen dentro del método sean transaccionales
     * si ocurre un error en alguna de las operaciones, se realizará un rollback
     * */
    @Transactional
    public void saveTransactional(List<User> users) {
        /**
         * Peek es usado para mostrar en pantalla lo que vengo registrando
         * */
        users.stream()
                .peek(user -> LOGGER.info("Saved user: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
