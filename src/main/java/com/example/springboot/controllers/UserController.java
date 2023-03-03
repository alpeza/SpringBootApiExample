package com.example.springboot.controllers;

import com.example.springboot.domain.User;
import com.example.springboot.repositories.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRespository userRespository;

    @GetMapping("/user")
    public List<User> getUsers(){
        return userRespository.findAllUsers();
    }

    @GetMapping("/user/{name}")
    public List<User> findUser(@PathVariable String name){
        logger.info("Se solicita la información para el usuario: " + name);
        return userRespository.findUserByName(name);
    }

    @PostMapping(value="/user")
    public void addUser(@RequestBody User user) {
        logger.info("Se esta tratando de registrar un nuevo usuario");
        logger.info(user.toString());
        logger.info("Insertamos el registro en base de datos y haciendo commit");
        userRespository.save(user);

    }

    @DeleteMapping("/user/{iduser}")
    public void deleteUser(@PathVariable Long iduser){
        logger.info("Se va a eliminar el usuario con id : " + Long.toString(iduser));
        userRespository.deleteById(iduser);
    }

    @PutMapping("/user/{iduser}")
    public void updateUser(@PathVariable int iduser, @RequestBody User user){
        logger.info("Se va a updatear el usuario con id : " + Long.toString(iduser) +
                " con la siguiente información: " + user.toString());
        User userToUpdate = userRespository.findById(iduser);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setTelephone(user.getTelephone());
        userRespository.save(userToUpdate);
    }
}