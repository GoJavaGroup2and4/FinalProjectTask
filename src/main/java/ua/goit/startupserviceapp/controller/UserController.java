package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.RoleRepository;
import ua.goit.startupserviceapp.service.SecurityService;
import ua.goit.startupserviceapp.service.UserService;
import ua.goit.startupserviceapp.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for {@link ua.goit.startupserviceapp.model.UserDB}'s pages.
 *
 * @author Anastasiya Kravchenko
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDB());

        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDB userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);


        if (bindingResult.hasErrors()) {
            return "registration";
        }


        userService.save(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password is incorrect. ");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully. ");
        }
        return "login";
    }

    @RequestMapping(value = {"/","home"},method = RequestMethod.GET)
    public String home (Model model){
        return "home";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }

    @RequestMapping(value = {"/welcome"},method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }
}
