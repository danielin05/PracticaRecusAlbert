package com.project.Classes;

public class Client extends Persona{
    int vegades_lloguer;
    boolean te_lloguer;

    public Client(String sexe, String nom, String cognom, String dni, int id, int num_telf, int edat, int vegades_lloguer, boolean te_lloguer) {
        super(sexe, nom, cognom, dni, id, num_telf, edat);
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
    
    @Override
    public String toString() {
        return "Client [id = " + id + ", sexe = " + sexe + ", nom = " + nom + ", cognom = " + cognom + ", dni = " + dni + ", num_telf = "
                + num_telf + ", edat = " + edat + ", te_lloguer = " + te_lloguer + ", vegades_lloguer = " + vegades_lloguer + "]";
    }
    
}
