package com.project.Classes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Persona {
    String sexe, nom, cognom, dni;
    int id, num_telf, edat;

    public Persona(int id){
        this.id = id;
    };

    public Persona( int id, String nom, String cognom, String dni, String sexe, int edat, int num_telf) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.sexe = sexe;
        this.edat = edat;
        this.num_telf = num_telf;
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
    
    public Map<String, Object> toJson() {
        Map<String, Object> json = new LinkedHashMap();
        json.put("id", id);
        json.put("nom", nom);
        json.put("cognom", cognom);
        json.put("dni", dni);
        json.put("sexe", sexe);
        json.put("edat", edat);
        json.put("num_telf", num_telf);
        return json;
    }

    @Override
    public String toString() {
        return "Persona [id = " + id + ", sexe = " + sexe + ", nom = " + nom + ", cognom = " + cognom + ", dni = " + dni
                + ", num_telf = " + num_telf + ", edat = " + edat + "]";
    }

}

