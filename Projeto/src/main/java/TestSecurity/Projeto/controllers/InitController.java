package TestSecurity.Projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import TestSecurity.Projeto.services.InitServiceImpl;

@Controller
public class InitController {

    @Autowired
    InitServiceImpl initServiceImpl;

    @GetMapping (value="/init")
    public ModelAndView init(){
        ModelAndView mav = new ModelAndView("init");

        initServiceImpl.initUsers();
        initServiceImpl.initTShirts();
        initServiceImpl.initSweaters();
        initServiceImpl.initCaps();
        initServiceImpl.initHoodies();
        initServiceImpl.initRoles();

        return mav;
    }

}
