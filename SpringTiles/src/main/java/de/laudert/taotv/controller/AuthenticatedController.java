package de.laudert.taotv.controller;

import de.laudert.taotv.config.CustomSessionRegistry;
import de.laudert.taotv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:15 PM
 */
@Controller
public class AuthenticatedController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomSessionRegistry sessionRegistry;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("currentPage", "home");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, ModelMap model, HttpSession session) {
        System.out.println("INSIDE LOGIN CONTROLLER!!!");
//        String returnView = "/admin/cartAdmin";
        String returnView = "login";
        if (error != null) {
            model.addAttribute(error, "Invalid Username or Password");
            returnView = "login";
        }

        if (logout != null) {
            model.addAttribute(logout, "You've been logged out successfully!");
        }

        return returnView;
    }

    @RequestMapping(value = "/error")
    public String accessDenied() {
        System.out.println("ACCESS DENIED");
        return "error";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        System.out.println("LOGGING OUT!");
        return "j_spring_security_logout";
    }

    @RequestMapping(value = "/userList")
    public String userList(ModelMap model) {
        StopWatch sw = new StopWatch();
        sw.start();
        model.addAttribute("users", userService.loadUsersPagination(1, 50));
        model.addAttribute("pages", userService.count() / 50);
        sw.stop();
        System.out.println("=====TOTAL LOADING TIME: " + sw.getLastTaskTimeMillis());
        model.addAttribute("currentPage", "userlist");
        return "userList";
    }

    @RequestMapping(value = "/allUserList")
    public String allUserList(ModelMap model) {
        StopWatch sw = new StopWatch();
        sw.start();
        model.addAttribute("users", userService.findAll());
        model.addAttribute("pages", userService.count() / 50);
        sw.stop();
        System.out.println("=====TOTAL LOADING TIME: " + sw.getLastTaskTimeMillis());
        model.addAttribute("currentPage", "alluserlist");
        return "userList";
    }

    @RequestMapping(value = "/expire")
    public String expireNow(ModelMap model, HttpSession session) {
        sessionRegistry.getSessionInformation(session.getId()).expireNow();
        return "expire";
    }
}
