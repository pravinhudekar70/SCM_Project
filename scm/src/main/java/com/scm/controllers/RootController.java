package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.helper.Helper;
import com.scm.services.UserService;

@ControllerAdvice
public class RootController {
 Logger logger = LoggerFactory.getLogger(getClass());

 @Autowired
 private UserService userService;
    
    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication ){
        if (authentication == null) {
            return;
        }
        String username = Helper.getEmailOfLoggedInUser(authentication);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("User looged in:{}",username);

        User user = userService.getUserByEmail(username);
    
        model.addAttribute("loggedInUser", user);
        


    }
}
