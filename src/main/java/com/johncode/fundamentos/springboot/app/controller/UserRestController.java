package com.johncode.fundamentos.springboot.app.controller;

import com.johncode.fundamentos.springboot.app.caseuse.CreateUser;
import com.johncode.fundamentos.springboot.app.caseuse.DeleteUser;
import com.johncode.fundamentos.springboot.app.caseuse.GetUser;
import com.johncode.fundamentos.springboot.app.caseuse.UpdateUser;
import com.johncode.fundamentos.springboot.app.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    /**
     * Creacion de capa relacionada con el servicio REST
     * CRUD
     * Create Read Update Delete
     * */

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    public UserRestController(GetUser getUser,
                              CreateUser createUser,
                              DeleteUser deleteUser,
                              UpdateUser updateUser){
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    /**
     * GET
     * */

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(getUser.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(getUser.getById(id), OK);
    }

    /**
     * POST
     * */

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(createUser.save(user), CREATED);
    }

    /**
     * PUT
     * */

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(user, id), OK);
    }

    /**
     * DELETE
     * */

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
