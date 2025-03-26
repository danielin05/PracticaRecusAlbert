package com.project.Classes;

public class Persona {
    String sexe, nom, cognom, dni;
    int id, num_telf, edat;

    public Persona(int id){
        this.id = id;
    };

    public Persona(String sexe, String nom, String cognom, String dni, int id, int num_telf, int edat) {
        this.sexe = sexe;
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.id = id;
        this.num_telf = num_telf;
        this.edat = edat;
    }

    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNum_telf() {
        return num_telf;
    }
    public void setNum_telf(int num_telf) {
        this.num_telf = num_telf;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Persona [id = " + id + ", sexe = " + sexe + ", nom = " + nom + ", cognom = " + cognom + ", dni = " + dni
                + ", num_telf = " + num_telf + ", edat = " + edat + "]";
    }

}

