package com.ang.spring.projet.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "data_dembouche")
    private Date date_dembouche;
    @Column(name = "Mail")
    private String Mail;
    @Column(name = "tel")
    private String tel;
    @Column(name = "date_a")
    private Date dateAeith ;

    @Column(name = "matricle")
    private String matricle;
    @ManyToOne
    @JoinColumn(name = "nom_service")
    private Services nom_service;
    public Employee(int id, String nom, Date date_dembouche, String mail, String tel, Date dateAeith, String matricle, Services nom_service) {
        this.id = id;
        this.nom = nom;
        this.date_dembouche = date_dembouche;
        this.Mail = mail;
        this.tel = tel;
        this.dateAeith = dateAeith;
        this.matricle = matricle;
        this.nom_service = nom_service;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_dembouche() {
        return date_dembouche;
    }

    public void setDate_dembouche(Date date_dembouche) {
        this.date_dembouche = date_dembouche;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        this.Mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateAeith() {
        return dateAeith;
    }

    public void setDateAeith(Date dateAeith) {
        this.dateAeith = dateAeith;
    }

    public String getMatricle() {
        return matricle;
    }

    public void setMatricle(String matricle) {
        this.matricle = matricle;
    }

    public Services getNom_service() {
        return nom_service;
    }

    public void setNom_service(Services nom_service) {
        this.nom_service = nom_service;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date_dembouche=" + date_dembouche +
                ", Mail='" + Mail + '\'' +
                ", tel='" + tel + '\'' +
                ", dateAeith=" + dateAeith +
                ", matricle='" + matricle + '\'' +
                ", nom_service=" + nom_service +
                '}';
    }
}
