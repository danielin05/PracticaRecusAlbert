package com.project.Classes;

public class Empleat extends Persona{
    String carrec;
    int anys_empresa;
    boolean contractat;

    
    public Empleat(String sexe, String nom, String cognom, String dni, int id, int num_telf, int edat, String carrec, int anys_empresa, boolean contractat) {
        super(sexe, nom, cognom, dni, id, num_telf, edat);
        this.carrec = carrec;
        this.anys_empresa = anys_empresa;
        this.contractat = contractat;
    }

    public String getCarrec() {
        return carrec;
    }
    public void setCarrec(String carrec) {
        this.carrec = carrec;
    }
    public int getAnys_empresa() {
        return anys_empresa;
    }
    public void setAnys_empresa(int anys_empresa) {
        this.anys_empresa = anys_empresa;
    }
    public boolean isContractat() {
        return contractat;
    }
    public void setContractat(boolean contractat) {
        this.contractat = contractat;
    }

    @Override
    public String toString() {
        return "Client [sexe = " + sexe + ", nom = " + nom + ", cognom = " + cognom + ", dni = " + dni + ", num_telf = "
                + num_telf + ", edat = " + edat + ", carrec = " + carrec + ", anys_empresa = " + anys_empresa + ", contractat = " + contractat + "]";
    }
}
