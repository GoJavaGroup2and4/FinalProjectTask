package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.service.CategoryService;
import ua.goit.startupserviceapp.service.SecurityService;
import ua.goit.startupserviceapp.service.StartupService;
import ua.goit.startupserviceapp.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartupController extends HttpServlet {

    @Autowired
    private StartupService startupService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
	private SecurityService securityService;

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

    @RequestMapping(value = "mystartups", method = RequestMethod.GET)
    public String mystartups(Model model, HttpServletRequest request) {
        model.addAttribute("startup", new Startup());
        model.addAttribute("user", this.userService.getAuthenticatedUser(request));
        model.addAttribute("allUserStartups", this.startupService.getStartupsByUser(userService.getAuthenticatedUser(request)));

        return "mystartups";
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

    @RequestMapping(value = "/startupedit/{id}", method = RequestMethod.GET)
    public String editStartup(@PathVariable("id") Long id, Model model, HttpServletRequest request) {

        if(this.userService.isStartupOwner(id, request)) {
            model.addAttribute("startup", this.startupService.getStartupById(id));
            model.addAttribute("is_authenticated", this.userService.isAuthenticated(request));
            model.addAttribute("categories", this.categoryService.getAllCategories());
            model.addAttribute("category_names", this.categoryService.getAllCategoryNames());
            return "startupedit";
        }
        else {
            return "redirect:/startupdetails/{id}";
        }
    }

    @RequestMapping(value = "startupedit/{id}", method = RequestMethod.POST)
    public String editStartup(@ModelAttribute("startup") Startup startup){

        Category category = categoryService.getCategoryByName(startup.getCategory().getName());
        startup.setCategory(category);

        this.startupService.edit(startup);

        return "redirect:/startupdetails/{id}";
    }

    @RequestMapping(value = "/startupdetails/{id}")
    public String startupDetails (@PathVariable("id") long id, Model model, HttpServletRequest request){

        model.addAttribute("startup", this.startupService.getStartupById(id));
        model.addAttribute("is_admin", this.userService.isAdmin(request));
        model.addAttribute("is_owner", this.userService.isStartupOwner(id, request));
        model.addAttribute("is_authenticated", this.userService.isAuthenticated(request));
        model.addAttribute("average_rating", this.startupService.averageRating(id));
        model.addAttribute("votes_count", this.startupService.votesCount(id));

        return "startupdetails";
    }

    @RequestMapping(value = "/startupdetails/{id}/invest", method = RequestMethod.POST)
    public String startupInvest (@RequestParam("investment") int investment, @PathVariable ("id") long startupId, HttpServletRequest request){
        
        if(userService.isAuthenticated(request)) {
            this.startupService.invest(startupId, investment);

            return "redirect:/startupdetails/{id}";
        }
        else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/startupdetails/sendforapprove/{id}")
    public String sendForApprove (@PathVariable ("id") long id, Model model){

        this.startupService.ready(id);

        return "redirect:/startupdetails/{id}";
    }

    @RequestMapping(value = "/startupdetails/approve/{id}")
    public String approve (@PathVariable ("id") long id, Model model){

        this.startupService.approve(id);

        return "redirect:/startupdetails/{id}";
    }

    @RequestMapping(value = "/startupdetails/reject/{id}")
    public String reject (@PathVariable ("id") long id, Model model){

        this.startupService.reject(id);

        return "redirect:/startupdetails/{id}";
    }

    @RequestMapping(value = "/startupdetails/delete/{id}")
    public String delete (@PathVariable ("id") long id, Model model){

        this.startupService.deleteById(id);

        return "redirect:/startupdetails/{id}";
    }

    @RequestMapping(value = "/startupdetails/close/{id}")
    public String close (@PathVariable ("id") long id, Model model){

        this.startupService.close(id);

        return "redirect:/startupdetails/{id}";
    }
}
