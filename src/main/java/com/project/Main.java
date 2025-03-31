package com.project;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.Classes.Empleat;
import com.project.Classes.Empresa;
import com.project.Classes.Lloguer;
import com.project.Classes.Vehicle;
import com.project.Classes.Client;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import kotlin.io.OnErrorAction;

public class Main {

    private final File dataFile;

    public Main(File dataFile) {
        this.dataFile = dataFile;
    }
    public static void main(String[] args) {
        

    }

    
    public Empresa loadJSON() {
        Empresa empresa = new Empresa();
        List<Client> clients = new ArrayList<>();
        List<Empleat> empleats = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Lloguer> lloguers = new ArrayList<>();

        try (JsonReader jsonReader = Json.createReader(new FileReader(dataFile))) {
            JsonObject jsonObject = jsonReader.readObject();

            // Cargar clientes
            JsonArray clientsArray = jsonObject.getJsonArray("clientes");
            for (JsonObject clientObject : clientsArray.getValuesAs(JsonObject.class)) {
                clients.add(new Client(
                        clientObject.getInt("id"),
                        clientObject.getString("nom"),
                        clientObject.getString("cognom"),
                        clientObject.getString("dni"),
                        clientObject.getString("sexe"),
                        clientObject.getInt("edat"),
                        clientObject.getInt("num_telf"),
                        clientObject.getInt("vegades_lloguer"),
                        clientObject.getBoolean("te_lloguer")
                ));
            }

            // Cargar empleados
            JsonArray empleatsArray = jsonObject.getJsonArray("empleados");
            for (JsonObject empleatObject : empleatsArray.getValuesAs(JsonObject.class)) {
                empleats.add(new Empleat(
                    empleatObject.getInt("id"),
                    empleatObject.getString("nom"),
                    empleatObject.getString("cognom"),
                    empleatObject.getString("dni"),
                        empleatObject.getString("sexe"),
                        empleatObject.getInt("edat"),
                        empleatObject.getInt("num_telf"),
                        empleatObject.getString("carrec"),
                        empleatObject.getInt("anys_empresa"),
                        empleatObject.getBoolean("contractat")
                ));
            }

            // Cargar vehículos
            JsonArray vehiclesArray = jsonObject.getJsonArray("vehiculos");
            for (JsonObject vehicleObject : vehiclesArray.getValuesAs(JsonObject.class)) {
                vehicles.add(new Vehicle(
                        vehicleObject.getInt("id"),
                        vehicleObject.getInt("kilometratge"),
                        vehicleObject.getInt("vegades_llogat"),
                        vehicleObject.getString("marca"),
                        vehicleObject.getString("model"),
                        vehicleObject.getString("matricula"),
                        (float) vehicleObject.getJsonNumber("preu_dia").doubleValue(),
                        vehicleObject.getBoolean("esta_llogat")
                ));
            }

            // Cargar alquileres
            JsonArray lloguersArray = jsonObject.getJsonArray("lloguers");
            for (JsonObject lloguerObject : lloguersArray.getValuesAs(JsonObject.class)) {
                Client client = null;
                for (Client c : clients) {
                    if (c.getDni().equals(lloguerObject.getString("client"))) {
                        client = c;
                        break;
                    }
                }

                Empleat empleat = null;
                for (Empleat e : empleats) {
                    if (e.getDni().equals(lloguerObject.getString("empleat"))) {
                        empleat = e;
                        break;
                    }
                }

                Vehicle vehicle = null;
                for (Vehicle v : vehicles) {
                    if (v.getMatricula().equals(lloguerObject.getString("vehicle"))) {
                        vehicle = v;
                        break;
                    }
                }

                if (client != null && empleat != null && vehicle != null) {
                    lloguers.add(new Lloguer(
                            lloguerObject.getInt("id"),
                            client,
                            empleat,
                            vehicle,
                            lloguerObject.getString("dataInici"),
                            lloguerObject.getString("dataFi")
                    ));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        empresa.setLlistaClients(clients);
        empresa.setLlistaEmpleats(empleats);
        empresa.setLlistaLloguers(lloguers);
        empresa.setLlistaVehicles(vehicles);

       return empresa;
    }

    public void saveJSON(Empresa empresa, String filePath) {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        // Guardar clientes
        JsonArrayBuilder clientesArray = Json.createArrayBuilder();
        for (Client client : empresa.getLlistaClients()) {
            JsonObject clientJson = Json.createObjectBuilder(client.toJson()).build();
            clientesArray.add(clientJson);
        }
        jsonBuilder.add("clientes", clientesArray);

        // Guardar empleados
        JsonArrayBuilder empleatsArray = Json.createArrayBuilder();
        for (Empleat empleat : empresa.getLlistaEmpleats()) {
            JsonObject empleatJson = Json.createObjectBuilder(empleat.toJson()).build();
            empleatsArray.add(empleatJson);
        }
        jsonBuilder.add("empleados", empleatsArray);

        // Guardar vehículos
        JsonArrayBuilder vehiclesArray = Json.createArrayBuilder();
        for (Vehicle vehicle : empresa.getLlistaVehicles()) {
            JsonObject vehicleJson = Json.createObjectBuilder(vehicle.toJson()).build();
            vehiclesArray.add(vehicleJson);
        }
        jsonBuilder.add("vehiculos", vehiclesArray);

        // Guardar alquileres
        JsonArrayBuilder lloguersArray = Json.createArrayBuilder();
        for (Lloguer lloguer : empresa.getLlistaLloguers()) {
            JsonObject lloguerJson = Json.createObjectBuilder(lloguer.toJson()).build();
            lloguersArray.add(lloguerJson);
        }
        jsonBuilder.add("lloguers", lloguersArray);

        // Guardar en archivo JSON
        try (JsonWriter jsonWriter = Json.createWriter(Files.newBufferedWriter(Paths.get(dataFile.getParent(), "data.json")))) {
            jsonWriter.writeObject(jsonBuilder.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}