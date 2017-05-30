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
import ua.goit.startupserviceapp.service.CategoryService;
import ua.goit.startupserviceapp.service.SecurityService;
import ua.goit.startupserviceapp.service.StartupService;
import ua.goit.startupserviceapp.validator.StartupValidator;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartupController {

    @Autowired
    private StartupService startupService;

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

    @RequestMapping("startupdetails/{id}")
    public String startupDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("startup", this.startupService.getStartupById(id));

        return "startupdetails";
    }
}
