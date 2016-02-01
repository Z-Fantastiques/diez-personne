package com.diez_personne.web;

import com.diez_personne.repository.ArticleRepository;
import com.diez_personne.repository.QuotationRepository;
import com.diez_personne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by linard_f on 1/25/16.
 */
@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
