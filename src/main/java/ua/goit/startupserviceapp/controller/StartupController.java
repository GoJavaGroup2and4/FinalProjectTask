package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.service.StartupService;

@Controller
public class StartupController {
    private StartupService startupService;

    @Autowired(required = true)
//    @Qualifier(value = "startupService")
    public void setStartupService(StartupService startupService) {
        this.startupService = startupService;
    }

    @RequestMapping(value = "startups", method = RequestMethod.GET)
    public String listStartups(Model model) {
        model.addAttribute("startup", new Startup());
        model.addAttribute("listStartups", this.startupService.getAllStartups());

        return "startups";
    }

    @RequestMapping(value = "startups/add", method = RequestMethod.POST)
    public String addStartup(@ModelAttribute("startup") Startup startup) {
        if (startup.getId() == 0) {
            this.startupService.save(startup);
        } else {
            this.startupService.edit(startup);
        }

        return "redirect:/startups";
    }

    @RequestMapping("/remove/{id}")
    public String removeStartup(@PathVariable("id") Long id) {
        this.startupService.deleteById(id);

        return "redirect:/startups";
    }

    @RequestMapping("edit/{id}")
    public String editStartup(@PathVariable("id") Long id, Model model) {
        model.addAttribute("startup", this.startupService.getStartupById(id));
        model.addAttribute("listStartups", this.startupService.getAllStartups());

        return "startups";
    }

    @RequestMapping("startupdetails/{id}")
    public String startupDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("startup", this.startupService.getStartupById(id));

        return "startupdetails";
    }
}
