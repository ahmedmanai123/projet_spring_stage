package com.ang.spring.projet.Dto;

public class ServiceDto {
    private long id;
    private String nom_service;


    @Override
    public String toString() {
        return "ServiceDto{" +
                "id=" + id +
                ", nom_service='" + nom_service + '\'' +
                '}';
    }


    public ServiceDto() {
    }
    public ServiceDto(long id, String nom_service) {
        this.id = id;
        this.nom_service = nom_service;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }
}
