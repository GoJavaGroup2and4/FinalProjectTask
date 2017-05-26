package ua.goit.startupserviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.model.Startup;
import ua.goit.startupserviceapp.service.StartupService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartupController extends HttpServlet {
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
        return "sturtupedit";
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //    response.sendRedirect("/newStartup/add");

    }

    @Override
    @RequestMapping(value = "startup/servlet-parameters")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("Utf-8");

        if (request.getParameterMap().size() >0) {
            int id = Integer.parseInt(request.getParameter("id"));
            Startup s;
            if (id == 0) {
                s = new Startup();
            } else {
                //        s = new StartupServiceImpl().getStartupById(id);
            }

        /*    try {
                InputStream st = request.getPart("photo").getInputStream();
                Blob blob = new Dao().createBlob(st);
                user.setPhoto(blob);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            process(request, user);
        }
        response.sendRedirect("../users.html");*/
        }
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
