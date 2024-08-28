package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String indexPage() {
        return "redirect:/home";
    }
    
    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("name", "Pravin Hudekar");
        model.addAttribute("mobileNo", "9325624419");
        model.addAttribute("linkedin", "https://www.linkedin.com/in/pravin-hudekar-75b22b221/");
        System.out.println("Home Page Handler");
        return "home";
    }
    //about 
    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("in about page");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("in services page");
        return "services";
    }

    //contact
    @GetMapping("/contact")
    public String contactPage(){
        System.out.println("in contact page");
        return "contact";
    }

    // login
    @GetMapping("/login")
    public String loginPage(){
        System.out.println("in login page");
        return  "login";
    }
    

    //register
    @GetMapping("/register")
    public String registerPage(Model model){
        UserForm userForm = new UserForm();
       model.addAttribute("userForm", userForm);
        // //default data
        // userForm.setName("pravin");
        // userForm.setAbout("this is about me ");

        return "register";
    }
    // processing register
    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm ,BindingResult rBindingResult ,  HttpSession session){
        System.out.println("Pocessing registration");
        System.out.println(userForm);
            //validate form data
                if(rBindingResult.hasErrors()){
                    return "register";
                }
        // we hava to featch a form data
        //user service 
        // userForm --> data nikal user me dala
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .build();
        User user = new User();
        user.setName(userForm.getName()); 
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
         User savaUser = userService.savaUser(user);
         System.out.println("-----------user saved -----------");
         
         //add the message
         Message message = Message.builder().content("Registration Successful").type(MessageType.blue).build();
        session.setAttribute("message", message);

    return "redirect:/register";
    }


}
