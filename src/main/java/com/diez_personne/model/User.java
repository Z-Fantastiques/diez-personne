package com.diez_personne.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linard_f on 1/27/16.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Article> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        if (article != null) {
            if (articles == null) {
                articles = new HashSet<>();
            }
            articles.add(article);
            article.setUser(this);
        }
    }
}
