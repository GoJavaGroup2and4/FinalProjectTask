package ua.goit.startupserviceapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/test
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
