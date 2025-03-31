package com.project.Classes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vehicle {
    int id, kilometratge, vegades_llogat;
    String marca, model, matricula;
    double preu_dia;
    boolean esta_llogat;

    public Vehicle(int id){
        this.id = id;
    };

    public Vehicle(int id, int kilometratge, int vegades_llogat, String marca, String model, String matricula, double preu_dia, boolean esta_llogat) {
        this.id = id;
        this.kilometratge = kilometratge;
        this.vegades_llogat = vegades_llogat;
        this.marca = marca;
        this.model = model;
        this.matricula = matricula;
        this.preu_dia = preu_dia;
        this.esta_llogat = esta_llogat;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getKilometratge() {
        return kilometratge;
    }
    public void setKilometratge(int kilometratge) {
        this.kilometratge = kilometratge;
    }
    public int getVegades_llogat() {
        return vegades_llogat;
    }
    public void setVegades_llogat(int vegades_llogat) {
        this.vegades_llogat = vegades_llogat;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public double getPreu_dia() {
        return preu_dia;
    }
    public void setPreu_dia(double preu_dia) {
        this.preu_dia = preu_dia;
    }
    public boolean isEsta_llogat() {
        return esta_llogat;
    }
    public void setEsta_llogat(boolean esta_llogat) {
        this.esta_llogat = esta_llogat;
    }

    public Map<String, Object> toJson() {
        Map<String, Object> json = new LinkedHashMap();
        json.put("id", id);
        json.put("kilometratge", kilometratge);
        json.put("vegades_llogat", vegades_llogat);
        json.put("marca", marca);
        json.put("model", model);
        json.put("matricula", matricula);
        json.put("preu_dia", preu_dia);
        json.put("esta_llogat", esta_llogat);
        return json;
    }

    @Override
    public String toString() {
        return "Vehicle [id = " + id + ", kilometratge = " + kilometratge + ", vegades_llogat = " + vegades_llogat
                + ", marca = " + marca + ", model = " + model + ", matricula = " + matricula + ", preu_dia = " + preu_dia
                + ", esta_llogat = " + esta_llogat + "]";
    }

}
