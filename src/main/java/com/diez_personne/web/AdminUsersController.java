package com.diez_personne.web;

import com.diez_personne.model.User;
import com.diez_personne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by linard_f on 2/6/16.
 */
@Controller
public class AdminUsersController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersList(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAllByOrderByFirstName());
        return "admin_users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() && (bindingResult.getErrorCount() > 1  || "".equals(user.getPassword()))) {
            model.addAttribute("error", "Le formulaire soumis contient des erreurs.");
            return usersList(model);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setName(user.getName().toLowerCase());
        userRepository.save(user);
        return "redirect:/users";
    }

}
