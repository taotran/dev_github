package de.laudert.taotv.controller;

import de.laudert.taotv.exception.ItemNotFoundException;
import de.laudert.taotv.service.user.UserService;
import de.laudert.taotv.service.user.UserSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: tvt
 * Date: 10/9/14
 * Time: 8:50 AM
 */
@Controller
public class AdministrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionService userSessionService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationController.class);

    @RequestMapping(value = "/admin/cartAdmin", method = RequestMethod.GET)
    public String cartAdmin(ModelMap model) {
        return "cartAdmin";
    }

    @RequestMapping(value = "/admin/delete/id={id}", method = RequestMethod.GET)
    @ExceptionHandler()
    public String deleteById(@PathVariable("id") Long id) throws ItemNotFoundException {
        userService.delete(id);
        return "userList";
    }

    @RequestMapping(value = "/sessionList", method = RequestMethod.GET)
    public String sessionList(ModelMap model) {
        model.addAttribute("usersessions", userSessionService.findAll());
        model.addAttribute("currentPage", "sessionlist");
        return "sessionList";
    }
}
