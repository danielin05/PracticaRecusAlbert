package com.project.Classes;

public class Lloguer {
    private int id;
    private String dataInici, dataFi;
    private Vehicle vehicle;
    private Client client;
    private Empleat empleat;
    private float preu_total;


    public Lloguer(int id, Client client, Empleat empleat, Vehicle vehicle, String dataInici, String dataFi) {
        this.id = id;
        this.vehicle = vehicle;
        this.client = client;
        this.empleat = empleat;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInici() {
        return dataInici;
    }

    public void setDataInici(String dataInici) {
        this.dataInici = dataInici;
    }

    public String getDataFi() {
        return dataFi;
    }

    public void setDataFi(String dataFi) {
        this.dataFi = dataFi;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Empleat getEmpleat() {
        return empleat;
    }

    public void setEmpleat(Empleat empleat) {
        this.empleat = empleat;
    }

    public float getPreu_total() {
        return preu_total;
    }

    public void setPreu_total(float preu_total) {
        this.preu_total = preu_total;
    }

    @Override
    public String toString() {
        return "Lloguer [id = " + id + ", dataInici = " + dataInici + ", dataFi = " + dataFi + ", vehicle = " + vehicle
                + ", client = " + client +  ", empleat = " + empleat + ", preu_total = " + preu_total + "]";
    }

}

