package com.telusko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
}
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request,
        HttpServletResponse response) {
        System.out.println("hello world !!");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String message;
        if (userName != null && !userName.equals("") && userName.equals("niku") &&
            password != null && !password.equals("") && password.equals("123")) {
            message = "Welcome " + userName + ".";
            return new ModelAndView("welcome", "message", message);
        } else {
            message = "Wrong username or password.";
            return new ModelAndView("errorPage", "message", message);
        }
    }
}