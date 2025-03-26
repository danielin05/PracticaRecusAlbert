package com.project.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Lloguer {
    private int id;
    private String dataInici, dataFi;
    private Vehicle vehicle;
    private Client client;
    private Empleat empleat;


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
        return calcula_preu_total();
    }

    private float calcula_preu_total(){
        return vehicle.preu_dia * calcular_dies(dataInici, dataFi);
    }

    private static long calcular_dies(String dataInici, String dataFi) {
        // Define el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convierte las cadenas de texto en objetos LocalDate
        LocalDate inicio = LocalDate.parse(dataInici, formatter);
        LocalDate fin = LocalDate.parse(dataFi, formatter);

        // Calcula la diferencia en días
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    @Override
    public String toString() {
        return "Lloguer [id = " + id + ", dataInici = " + dataInici + ", dataFi = " + dataFi + ", vehicle = " + vehicle
                + ", client = " + client +  ", empleat = " + empleat + ", preu_total = " + getPreu_total() + "]";
    }

}

