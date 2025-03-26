package com.candidatsae.candidat4sae8;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Candidat {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String email;
    @ElementCollection
    private Set<Integer> favoriteJobs = new HashSet<>();

    public Set<Integer> getFavoriteJobs() {
        return favoriteJobs;
    }

    public void setFavoriteJobs(Set<Integer> favoriteJobs) {
        this.favoriteJobs = favoriteJobs;
    }

    public Candidat() {
    }

    public Candidat(String nom, String prenom, String email) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
