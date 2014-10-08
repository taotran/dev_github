package de.laudert.taotv.controller;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/login")
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/loginSucceed")
    public String loginSucceed(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/loginFailed")
    public String loginFailed() {
        return "login";
    }
}
