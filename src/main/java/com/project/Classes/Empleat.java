package com.project.Classes;

import java.util.Map;

public class Empleat extends Persona{
    String carrec;
    int anys_empresa;
    boolean contractat;

    
    public Empleat(int id, String nom, String cognom, String dni, String sexe, int edat, int num_telf, String carrec, int anys_empresa, boolean contractat) {
        super(id, nom, cognom, dni, sexe, edat, num_telf);
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

    public Map<String, Object> toJson() {
        Map<String, Object> json = super.toJson(); // Llamamos al método de Persona
        json.put("carrec", carrec);
        json.put("anys_empresa", anys_empresa);
        json.put("contractat", contractat);
        return json;
    }

    @Override
    public String toString() {
        return String.format(
            "Empleat { id: %d, Sexe: %s, Nom: %s, Cognom: %s, DNI: %s, Telèfon: %s, Edat: %d, Càrrec: %s, Anys a l'Empresa: %d, Contractat: %b }",
            id, sexe, nom, cognom, dni, num_telf, edat, carrec, anys_empresa, contractat
        );
    }

}
