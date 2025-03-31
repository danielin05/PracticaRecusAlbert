package com.project.Classes;

import java.util.Map;

public class Client extends Persona{
    int vegades_lloguer;
    boolean te_lloguer;

    public Client(int id, String nom, String cognom, String dni, String sexe, int edat, int num_telf, int vegades_lloguer, boolean te_lloguer) {
        super(id, nom, cognom, dni, sexe, edat, num_telf);
        this.vegades_lloguer = vegades_lloguer;
        this.te_lloguer = te_lloguer;
    }

    public int getVegades_lloguer() {
        return vegades_lloguer;
    }
    public void setVegades_lloguer(int vegades_lloguer) {
        this.vegades_lloguer = vegades_lloguer;
    }
    public boolean isTe_lloguer() {
        return te_lloguer;
    }
    public void setTe_lloguer(boolean te_lloguer) {
        this.te_lloguer = te_lloguer;
    }

    public void incrementa_lloguer(){
        vegades_lloguer++;
    }
    
    public Map<String, Object> toJson() {
        Map<String, Object> json = super.toJson(); // Llamamos al método de Persona
        json.put("vegades_lloguer", vegades_lloguer);
        json.put("te_lloguer", te_lloguer);
        return json;
    }

    @Override
    public String toString() {
        return "Client [id = " + id + ", sexe = " + sexe + ", nom = " + nom + ", cognom = " + cognom + ", dni = " + dni + ", num_telf = "
                + num_telf + ", edat = " + edat + ", te_lloguer = " + te_lloguer + ", vegades_lloguer = " + vegades_lloguer + "]";
    }
    
}
