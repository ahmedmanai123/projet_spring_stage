package com.ang.spring.projet.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Services {
    @Id
    @Column(name = "id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nom_service", columnDefinition = "VARCHAR(255)")
    private String nom_service;

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    public Services(long id, String nom_service) {
        this.id = id;
        this.nom_service = nom_service;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Services() {
    }






}
