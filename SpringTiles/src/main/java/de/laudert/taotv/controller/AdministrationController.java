package de.laudert.taotv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: tvt
 * Date: 10/9/14
 * Time: 8:50 AM
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdministrationController {

    @RequestMapping(value = "cartAdmin", method = RequestMethod.GET)
    public String cartAdmin(ModelMap model) {
        return "cartAdmin";
    }

}
