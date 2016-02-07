package com.diez_personne.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by linard_f on 2/6/16.
 */
@Controller
public class AdminUsersController {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersList() {
        return "admin_users";
    }

}
