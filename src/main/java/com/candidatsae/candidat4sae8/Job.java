package com.candidatsae.candidat4sae8;

public class Job {
    private  int id;


    private String service;


    private boolean etat;

    public Job(int id, String service, boolean etat) {
        this.id = id;
        this.service = service;
        this.etat = etat;
    }

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
