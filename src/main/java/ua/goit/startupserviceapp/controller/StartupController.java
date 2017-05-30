package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.service.*;
import ua.goit.startupserviceapp.validator.StartupValidator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartupController extends HttpServlet {

    @Autowired
    private StartupService startupService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private StartupValidator startupValidator;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "allstartups", method = RequestMethod.GET)
    public String allstartups(Model model) {
        model.addAttribute("startup", new Startup());
        model.addAttribute("allStartups", this.startupService.getAllApprovedStartups());
        model.addAttribute("mobileStartups", this.startupService.getAllMobileStartups());
        model.addAttribute("investmentStartups", this.startupService.getAllInvestmentStartups());
        model.addAttribute("businessStartups", this.startupService.getAllBusinessStartups());
        model.addAttribute("categories", this.categoryService.getAllCategories());
        return "allstartups";
    }

    @RequestMapping(value = "/newStartup")
    public String newStartup(Model model) {
        model.addAttribute("startup", new Startup());
        //TODO use DAO getAll()
        List<Category> list = new ArrayList<>();
        list.add(new Category("category 1"));
        list.add(new Category("category 2"));
        list.get(1).setId(1);
        list.add(new Category("category 3"));
        list.get(2).setId(2);
        model.addAttribute("listCategory", list);
        return "startup/edit";
    }

    @RequestMapping(value = "allstartups/add", method = RequestMethod.POST)
    public String addStartup(@ModelAttribute("startup") Startup startup) {
        if (startup.getId() == 0) {
            this.startupService.save(startup);
        } else {
            this.startupService.edit(startup);
        }

        return "redirect:/allstartups";
    }

    @RequestMapping("/remove/{id}")
    public String removeStartup(@PathVariable("id") Long id) {
        this.startupService.deleteById(id);

        return "redirect:/allstartups";
    }

    @RequestMapping("edit/{id}")
    public String editStartup(@PathVariable("id") Long id, Model model) {
        model.addAttribute("startup", this.startupService.getStartupById(id));
        model.addAttribute("listStartups", this.startupService.getAllStartups());

        return "allstartups";
    }

    @RequestMapping(value = "/startupdetails/{id}", method = RequestMethod.GET)
    public String startupDetails (@PathVariable("id") long id, Model model, HttpServletRequest request){

        model.addAttribute("startup", this.startupService.getStartupById(id));
        model.addAttribute("is_admin", this.userService.isAdmin(request));
        model.addAttribute("is_owner", this.userService.isStartupOwner(id, request));
        model.addAttribute("is_authenticated", this.userService.isAuthenticated(request));
        model.addAttribute("average_rating", this.startupService.averageRating(id));
        model.addAttribute("votes_count", this.startupService.votesCount(id));

        return "startupdetails";
    }
}
