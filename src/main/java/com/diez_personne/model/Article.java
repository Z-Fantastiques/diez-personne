package com.diez_personne.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by linard_f on 1/27/16.
 */
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(min = 1)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date;

    @PrePersist
    private void onCreate() {
        setDate(new Timestamp(new Date().getTime()));
    }

    public Article() {

    }

    public Article(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
