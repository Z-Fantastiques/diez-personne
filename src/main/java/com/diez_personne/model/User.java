package com.diez_personne.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Column(length = 50, nullable = false, unique = true)
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = true)
    private String email;

    @NotNull
    @Size(min = 60, max = 60)
    @Column(nullable = false, length = 60)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy("date DESC")
    private Set<Article> articles;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities = new HashSet<>();

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }


}
