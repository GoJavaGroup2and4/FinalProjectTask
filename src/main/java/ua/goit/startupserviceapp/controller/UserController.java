package ua.goit.startupserviceapp.controller;

import ua.goit.startupserviceapp.model.User;
import ua.goit.startupserviceapp.service.UserService;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by Alexander on 19/05/2017.
 */
public class UserController{

    UserService userService;

    public UserController() {
    }

    @Transactional
    public List<User> printAllUsers(){
        return userService.getAllUsers();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
