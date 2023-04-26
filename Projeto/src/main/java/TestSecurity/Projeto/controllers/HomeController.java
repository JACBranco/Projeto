package TestSecurity.Projeto.controllers;

import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("index");

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            mav.addObject("username", user.getUsername());
        }

        return mav;
    }

}
