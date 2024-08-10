package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home.html")
    public String home(Model model){
        model.addAttribute("name", "Pravin Hudekar");
        model.addAttribute("mobileNo", "9325624419");
        model.addAttribute("linkedin", "https://www.linkedin.com/in/pravin-hudekar-75b22b221/");
        System.out.println("Home Page Handler");
        return "home";
    }
    //about 
    @RequestMapping("/about")
    public String aboutpage(){
        System.out.println("in about page");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicespage(){
        System.out.println("in services page");
        return "services";
    }


}
