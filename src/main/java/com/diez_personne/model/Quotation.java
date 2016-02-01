package com.diez_personne.model;

import javax.persistence.*;

/**
 * Created by linard_f on 1/27/16.
 */
@Entity
@Table(name="quotation")
public class Quotation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String quotation;

    public Quotation(String quotation) {
        this.quotation = quotation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuoation() {
        return quotation;
    }

    public void setQuoation(String quotation) {
        this.quotation = quotation;
    }

}
