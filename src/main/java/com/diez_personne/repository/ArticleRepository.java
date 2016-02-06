package com.diez_personne.repository;

import com.diez_personne.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by linard_f on 1/27/16.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByUserName(String name);
    List<Article> findAllByOrderByDateDesc();

}
