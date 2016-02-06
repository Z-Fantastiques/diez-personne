package com.diez_personne.web;

import com.diez_personne.model.User;
import com.diez_personne.repository.UserRepository;
import com.diez_personne.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

/**
 * Created by linard_f on 1/25/16.
 */
@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Optional<User> currentUser = userRepository.findByName(SecurityUtils.getCurrentLogin());
        model.addAttribute("user", currentUser.get());
        return "index";
    }


}
