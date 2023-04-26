package TestSecurity.Projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//import testeWAR.Projeto.services.UserServiceImpl;

@Controller
public class CapController {

    @GetMapping (value="/cap")
    public ModelAndView cap(){
        ModelAndView mav = new ModelAndView("cap");
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            mav.addObject("username", user.getUsername());
        }
        return mav;
    }
}
