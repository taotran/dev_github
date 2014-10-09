package de.laudert.taotv.controller;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:15 PM
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        System.out.println("Inside Controller");
        User user = new User();
        user.setId(3L);
        user.setUsername("taotran");
        user.setPassword("12345");

        userService.save(user);
        userService.findAll();
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, ModelMap model) {
        System.out.println("INSIDE LOGIN CONTROLLER!!!");
//        String returnView = "/admin/cartAdmin";
        String returnView = "login";
        if (error != null) {
            model.addAttribute(error, "Invalid Username or Password");
            returnView = "login";
        }

        if(logout != null) {
            model.addAttribute(logout, "You've been logged out successfully!");
        }
        return returnView;
    }

    @RequestMapping(value = "/loginSucceed")
    public String loginSucceed(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/loginFailed")
    public String loginFailed() {
        return "login";
    }

//    @RequestMapping(value = "/logout")
//    public String logout() {
//
//        return "login";
//    }
}
