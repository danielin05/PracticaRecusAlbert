package com.project.Classes;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Client> llistaClients;
    private List<Vehicle> llistaVehicles;
    private List<Lloguer> llistaLloguers;
    private List<Empleat> llistaEmpleats;

    public Empresa() {
        this.llistaClients = new ArrayList<>();
        this.llistaVehicles = new ArrayList<>();
        this.llistaLloguers = new ArrayList<>();
        this.llistaEmpleats = new ArrayList<>();
    }

    public List<Client> getLlistaClients() {
        return llistaClients;
    }

    public void setLlistaClients(List<Client> llistaClients) {
        this.llistaClients = llistaClients;
    }

    public List<Vehicle> getLlistaVehicles() {
        return llistaVehicles;
    }

    public void setLlistaVehicles(List<Vehicle> llistaVehicles) {
        this.llistaVehicles = llistaVehicles;
    }

    public List<Lloguer> getLlistaLloguers() {
        return llistaLloguers;
    }

    public void setLlistaLloguers(List<Lloguer> llistaLloguers) {
        this.llistaLloguers = llistaLloguers;
    }

    public List<Empleat> getLlistaEmpleats() {
        return llistaEmpleats;
    }

    public void setLlistaEmpleats(List<Empleat> llistaEmpleats) {
        this.llistaEmpleats = llistaEmpleats;
    }

    @Override
    public String toString() {
        return "Empresa [llistaClients = " + llistaClients + ", llistaVehicles = " + llistaVehicles + ", llistaLloguers = "
                + llistaLloguers + ", llistaEmpleats = " + llistaEmpleats + "]";
    }

}
