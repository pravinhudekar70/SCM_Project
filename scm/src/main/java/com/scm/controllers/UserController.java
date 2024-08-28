package com.scm.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;




@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    //user ka dashbord page
    @RequestMapping("/dashbord")
    public String userDashbord() {
        return "user/dashbord";
    }

    //user profile
    @RequestMapping("/profile")
    public String userProfile(Model model, Authentication authentication) {
       
       



        return "user/profile";
    }
   
    

    //user add contact page 

    //  user view contact page 

    //user edit contact page 

    // user delete contact  page 

    //user search  contact page 


}
