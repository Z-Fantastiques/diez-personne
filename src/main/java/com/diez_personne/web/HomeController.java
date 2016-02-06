package com.diez_personne.web;

import com.diez_personne.model.Article;
import com.diez_personne.model.User;
import com.diez_personne.repository.ArticleRepository;
import com.diez_personne.repository.UserRepository;
import com.diez_personne.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by linard_f on 1/25/16.
 */
@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Optional<User> currentUser = userRepository.findByName(SecurityUtils.getCurrentLogin());
        model.addAttribute("user", currentUser.get());
        model.addAttribute("article", new Article());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createNews(@Valid Article article, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        article.setUser(userRepository.findByName(SecurityUtils.getCurrentLogin()).get());
        articleRepository.save(article);
        return "redirect:/";
    }



}
