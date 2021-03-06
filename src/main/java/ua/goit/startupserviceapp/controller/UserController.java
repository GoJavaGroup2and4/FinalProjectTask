package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.goit.startupserviceapp.model.UserDB;
import ua.goit.startupserviceapp.repository.RoleRepository;
import ua.goit.startupserviceapp.service.SecurityService;
import ua.goit.startupserviceapp.service.StartupService;
import ua.goit.startupserviceapp.service.UserService;
import ua.goit.startupserviceapp.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;


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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StartupService startupService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDB());

        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDB userForm, @RequestParam("roleId") long id, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.getRoles().add(roleRepository.getOne(id));

        userService.save(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        return "redirect:/allstartups";
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

    @RequestMapping(value = "userdetails", method = RequestMethod.GET)
    public String userDetails(Model model){

        model.addAttribute("userForm", userService.findByLogin(securityService.getLoggedUserLogin()));

        return "userdetails";
    }

    @RequestMapping(value = "userdetails", method = RequestMethod.POST)
    public String userDetails(@ModelAttribute("userForm") UserDB userForm, Model model, HttpServletRequest request){
        userForm.setRoles(userService.findByLogin(userForm.getLogin()).getRoles());
        userForm.setPassword(userService.findByLogin(userForm.getLogin()).getPassword());
        userForm.setStartups(userService.getAuthenticatedUser(request).getStartups());

        userService.saveWithoutEncode(userForm);

        return "userdetails";
    }

    @RequestMapping(value = {"/","home"},method = RequestMethod.GET)
    public String home (Model model){
        return "home";
    }

    @RequestMapping(value = {"/welcome"},method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin (Model model, HttpServletRequest request){

        if(userService.isAdmin(request)){
            model.addAttribute("allstartups", startupService.getAllStartups());
            return "admin";
        }
        else {
            return "redirect:allstartups";
        }

    }
}
