package TestSecurity.Projeto.controllers;

import TestSecurity.Projeto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import TestSecurity.Projeto.repositories.UserRepository;

@Controller
public class SignupController {
    @Autowired
    UserService userService;

    @GetMapping (value="/signupForm")
    public ModelAndView signupForm(@RequestParam(required = false) String usernameMessage){
        ModelAndView mav = new ModelAndView("signupForm");
        mav.addObject("usernameMessage", usernameMessage);
        return mav;
    }

    @PostMapping(value="/signup")
    public RedirectView signup(String name, String address, String username, String password, RedirectAttributes redirectAttributes) {

        if (userService.usernameExistsInDB(username)) {
            RedirectView rv = new RedirectView("/projeto/signupForm");
            redirectAttributes.addAttribute("usernameMessage", "<div class=\"message\"><h4>That username already exists. Please choose a different one!</h4></div>");

            return rv;
        } else {
            RedirectView rv = new RedirectView("/projeto");
            userService.createUser(name, address, username, password);
            return rv;
        }
    }
}
