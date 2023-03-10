package com.ds.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of very simple REST controller for CRUD operations.
 */
@RestController
public class UserDataController {

    @Autowired
    private UserInterface controller;

    @GetMapping("/list")
    public List<User> listUsers() {
        return controller.list();
    }

    @GetMapping("/create")
    public User createNewUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email) {
        try {
            return controller.create(new User(null, name, email));
        } catch (UserManagementException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/delete")
    public void deleteUser(
            @RequestParam(value = "id") int id) throws UserManagementException {
        try {
            controller.delete(id);
        } catch (UserManagementException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/update")
    public void updateUser(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String newName,
            @RequestParam(value = "email") String newEmail) throws UserManagementException {
        try {
            controller.update(id, new User(newName, newEmail) );
        } catch (UserManagementException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
