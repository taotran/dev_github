package de.laudert.taotv.controller;

import de.laudert.taotv.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationController.class);

    @RequestMapping(value = "/admin/cartAdmin", method = RequestMethod.GET)
    public String cartAdmin(ModelMap model) {
        return "cartAdmin";
    }

    @RequestMapping(value = "/admin/delete/id={id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return "userList";
    }
}
