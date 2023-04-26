package TestSecurity.Projeto.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TesteController {

    @GetMapping ( "/teste")
    public ModelAndView teste(){
        ModelAndView mav = new ModelAndView("teste");
        return mav;
    }

    @GetMapping (value="/bloqueada")
    public ModelAndView bloqueada(){
        ModelAndView mav = new ModelAndView("/bloqueada");
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            mav.addObject("username", user.getUsername());
        }
        return mav;
    }

    @GetMapping ( "/user")
    public ModelAndView testeUser(){
        ModelAndView mav = new ModelAndView("teste");
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {

            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            mav.addObject("username", user.getUsername());
        }
        return mav;
    }

}
