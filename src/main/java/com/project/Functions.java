package com.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.project.Classes.Client;
import com.project.Classes.Empleat;
import com.project.Classes.Empresa;
import com.project.Classes.Lloguer;
import com.project.Classes.Vehicle;

public class Functions {

    public Empresa empresa;


    String menu_nous = 
    """
    ---------- MENU NOUS ----------
    1) Nou Lloguer
    2) Nou Vehicle
    3) Nou Empleat
    4) Nou Client
    5) Enrere
    """;

    String menu_mostrar = 
    """
    ---------- MENU MOSTRAR ----------
    1) Mostrar Lloguers
    2) Mostrar Vehicles
    3) Mostrar Empleats
    4) Mostrar Clients
    5) Enrere
    """;
    
    String menu_modificar = 
    """
    ---------- MENU MODIFICAR ----------
    1) Modificar Lloguer
    2) Modificar Vehicle
    3) Modificar Empleat
    4) Modificar Client
    5) Enrere
    """;

    // ========== FUNCIONES ==========

        // ========== MENUS DE GESTIONES ==========

    // Método para manejar el menú de nuevo registro
    public void gestio_nous(Scanner scanner) {
        boolean volverAlMenuPrincipal = false;
    
        while (!volverAlMenuPrincipal) {
            System.out.println(menu_nous);
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "1":
                    System.out.println("Nou Lloguer seleccionat");
                    nou_lloguer(scanner);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "2":
                    System.out.println("Nou Vehicle seleccionat");
                    nou_vehicle(scanner);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "3":
                    System.out.println("Nou Empleat seleccionat");
                    nou_empleat(scanner);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "4":
                    System.out.println("Nou Client seleccionat");
                    nou_client(scanner);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "5":
                    System.out.println("Tornant al menú principal");
                    volverAlMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Opció invàlida. Prova-ho de nou.");
            }
        }
    }
    

    // Método para manejar el menú de mostrar registros
    public void gestio_mostrar(Scanner scanner) {
        boolean volverAlMenuPrincipal = false;
        while (!volverAlMenuPrincipal) {
            System.out.println(menu_mostrar);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Mostrar Lloguers");
                    mostrar_lloguers(false);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "2":
                    System.out.println("Mostrar Vehicles");
                    mostrar_vehicles(false);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "3":
                    System.out.println("Mostrar Empleats");
                    mostrar_empleats(false);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "4":
                    System.out.println("Mostrar Clients");
                    mostrar_clients(false);
                    scanner.nextLine();  // Limpiar el buffer
                    break;
                case "5":
                    System.out.println("Tornant al menú principal");
                    volverAlMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Opció invàlida. Prova-ho de nou.");
            }
        }
    }


    // Método para manejar el menú de modificar registros
    public void gestio_modificar(Scanner scanner) {
        System.out.println(menu_modificar);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Modificar Lloguer");
                modificar_lloguer(scanner);
                break;
            case "2":
                System.out.println("Modificar Vehicle");
                modificar_vehicle(scanner);
                break;
            case "3":
                System.out.println("Modificar Empleat");
                modificar_empleat(scanner);
                break;
            case "4":
                System.out.println("Modificar Client");
                modificar_client(scanner);
                break;
            case "5":
                System.out.println("Tornant al menú principal");
                break;
            default:
                System.out.println("Opció invàlida. Prova-ho de nou.");
        }
        scanner.nextLine();  // Limpiar el buffer
    }


        // ========== GESTIONES ==========

    public void nou_lloguer(Scanner scanner){
        System.out.println("------ Creació d'un nou lloguer ------");

        String data_inici = selecciona_data_inici(scanner);

        String data_final = selecciona_data_final(scanner, data_inici);

        String matricula_vehicle = selecciona_vehicle(scanner, true);

        String dni_client = selecciona_client(scanner, true);

        String dni_empleat = selecciona_empleat(scanner, true);

        String resultat = 
        """
        
        ---------- Resultat ----------
        Client que lloga:   %s
        Empleat encarregat: %s
        Vehicle llogat:     %s
        Data d'inici:       %s
        Data de fi:         %s
        """.formatted(dni_client, dni_empleat, matricula_vehicle, data_inici, data_final);

        System.out.println(resultat);
        System.out.println("Desitja guardar el nou lloguer creat? Y/N: ");
        String guardar = scanner.nextLine();

        while(!guardar.toUpperCase().equals("Y") && !guardar.toUpperCase().equals("N")){
            System.out.println("Opcio invalida, escriu 'Y' per GUARDAR o 'N' per NO guardar.\n");
            System.out.println(resultat);
            System.out.println("Desitja guardar el nou lloguer creat? Y/N: ");
            guardar = scanner.nextLine();
        }
        
        if(guardar.toUpperCase().equals("Y")){
            System.out.println("Guardant el nou lloguer....");
            guardarNouLloguer(matricula_vehicle, dni_client, dni_empleat, data_inici, data_final);
        }else{
            System.out.println("NO se guardara el nou lloguer, tornant enrere.");
        }
    }

    public void nou_vehicle(Scanner scanner){
        System.out.println("------ Creació d'un nou vehicle ------");

        int id = empresa.getLlistaVehicles().stream()
            .mapToInt(Vehicle::getId)
            .max().orElse(0) + 1;
        
        System.out.println("Indica el kilometratge del nou vehicle: ");
        int kilometratge = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        
        System.out.println("Indica les vegades que ha estat llogat el nou vehicle: ");
        int vegades_llogat = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        
        System.out.println("Indica la marca del nou vehicle: ");
        String marca = scanner.nextLine();
        
        System.out.println("Indica el model del nou vehicle (Cotxe/Moto): ");
        String model = scanner.nextLine();
        
        String matricula = agrega_matricula(scanner);
        
        System.out.println("Indica el preu per dia del nou vehicle: ");
        double preu_dia = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer
        
        boolean esta_llogat = false;
        
        String resultat = 
        """
        ---------- Resultat ----------
        Kilometratge:   %s
        Vegades llogat: %s
        Marca:          %s
        Model:          %s
        Matricula:      %s
        Preu per dia:   %s
        """.formatted(kilometratge, vegades_llogat, marca, model, matricula, preu_dia);

        System.out.println(resultat);
        System.out.println("Desitja guardar el nou lloguer creat? Y/N: ");
        String guardar = scanner.nextLine();

        while(!guardar.toUpperCase().equals("Y") && !guardar.toUpperCase().equals("N")){
            System.out.println("Opcio invalida, escriu 'Y' per GUARDAR o 'N' per NO guardar.\n");
            System.out.println(resultat);
            System.out.println("Desitja guardar el nou lloguer creat? Y/N: ");
            guardar = scanner.nextLine();
        }
        
        if(guardar.toUpperCase().equals("Y")){
            System.out.println("Guardant el nou lloguer....");
            empresa.getLlistaVehicles().add(new Vehicle(id, kilometratge, vegades_llogat, marca, model, matricula, preu_dia, esta_llogat));
        }else{
            System.out.println("NO se guardara el nou lloguer, tornant enrere.");
        }
    }

    public void nou_empleat(Scanner scanner) {
        System.out.println("------ Creació d'un nou empleat ------");
    
        int id = empresa.getLlistaEmpleats().stream()
            .mapToInt(Empleat::getId)
            .max().orElse(0) + 1;
    
        System.out.println("Indica el nom del nou empleat: ");
        String nom = scanner.nextLine();
    
        System.out.println("Indica el cognom del nou empleat: ");
        String cognom = scanner.nextLine();
    
        String dni = agrega_dni(scanner, 1);
    
        System.out.println("Indica el sexe del nou empleat (Home/Dona): ");
        String sexe = scanner.nextLine();
    
        System.out.println("Indica l'edat del nou empleat: ");
        int edat = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
    
        System.out.println("Indica el número de telèfon del nou empleat: ");
        int num_telf = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
    
        System.out.println("Indica el càrrec del nou empleat: ");
        String carrec = scanner.nextLine();
    
        int anys_empresa = 0;
    
        boolean contractat = true;
    
        String resultat = 
        """
        ---------- Resultat ----------
        Nom:           %s
        Cognom:        %s
        DNI:           %s
        Sexe:          %s
        Edat:          %s
        Telèfon:       %s
        Càrrec:        %s
        """.formatted(nom, cognom, dni, sexe, edat, num_telf, carrec);
    
        System.out.println(resultat);
        System.out.println("Desitja guardar el nou empleat creat? Y/N: ");
        String guardar = scanner.nextLine();
    
        while (!guardar.toUpperCase().equals("Y") && !guardar.toUpperCase().equals("N")) {
            System.out.println("Opció invàlida, escriu 'Y' per GUARDAR o 'N' per NO guardar.\n");
            System.out.println(resultat);
            System.out.println("Desitja guardar el nou empleat creat? Y/N: ");
            guardar = scanner.nextLine();
        }
    
        if (guardar.toUpperCase().equals("Y")) {
            System.out.println("Guardant el nou empleat....");
            empresa.getLlistaEmpleats().add(new Empleat(id, nom, cognom, dni, sexe, edat, num_telf, carrec, anys_empresa, contractat));
        } else {
            System.out.println("NO se guardarà el nou empleat, tornant enrere.");
        }
    }

    public void nou_client(Scanner scanner) {
        System.out.println("------ Creació d'un nou client ------");
    
        int id = empresa.getLlistaClients().stream()
            .mapToInt(Client::getId)
            .max().orElse(0) + 1;
    
        System.out.println("Indica el nom del nou client: ");
        String nom = scanner.nextLine();
    
        System.out.println("Indica el cognom del nou client: ");
        String cognom = scanner.nextLine();

        String dni = agrega_dni(scanner, 2);
    
        System.out.println("Indica el sexe del nou client (Home/Dona): ");
        String sexe = scanner.nextLine();
    
        System.out.println("Indica l'edat del nou client: ");
        int edat = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
    
        System.out.println("Indica el número de telèfon del nou client: ");
        int num_telf = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
    
        int vegades_lloguer = 0;
    
        boolean te_lloguer = false;
    
        String resultat = 
        """
        ---------- Resultat ----------
        Nom:           %s
        Cognom:        %s
        DNI:           %s
        Sexe:          %s
        Edat:          %s
        Telèfon:       %s
        Vegades llogat: %s
        Té lloguer:    %s
        """.formatted(nom, cognom, dni, sexe, edat, num_telf, vegades_lloguer, te_lloguer);
    
        System.out.println(resultat);
        System.out.println("Desitja guardar el nou client creat? Y/N: ");
        String guardar = scanner.nextLine();
    
        while (!guardar.toUpperCase().equals("Y") && !guardar.toUpperCase().equals("N")) {
            System.out.println("Opció invàlida, escriu 'Y' per GUARDAR o 'N' per NO guardar.\n");
            System.out.println(resultat);
            System.out.println("Desitja guardar el nou client creat? Y/N: ");
            guardar = scanner.nextLine();
        }
    
        if (guardar.toUpperCase().equals("Y")) {
            System.out.println("Guardant el nou client....");
            empresa.getLlistaClients().add(new Client(id, nom, cognom, dni, sexe, edat, num_telf, vegades_lloguer, te_lloguer));
        } else {
            System.out.println("NO se guardarà el nou client, tornant enrere.");
        }
    }
    

    public String agrega_matricula(Scanner scanner) {
        String matricula = "";
        boolean correcte = false;
        List<Vehicle> vehicles = empresa.getLlistaVehicles();
    
        while (!correcte) {
            System.out.println("Introdueix la matricula del nou vehicle: ");
            matricula = scanner.nextLine();
    
            // Verificar si la matrícula ya existe en la lista de vehículos
            boolean matriculaExiste = false;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getMatricula().equals(matricula)) {
                    matriculaExiste = true;
                    break;
                }
            }
    
            // Si no se encontró la matrícula, es válida
            if (!matriculaExiste) {
                correcte = true;
            }
    
            // Si la matrícula ya está registrada, informamos al usuario
            if (matriculaExiste) {
                System.out.println("Matrícula ya registrada, prova de nou.");
            }
        }
    
        return matricula;
    }
    
    public String agrega_dni(Scanner scanner, int type) {
        String dni = "";
        boolean correcte = false;
        List<Empleat> empleats = empresa.getLlistaEmpleats();
        List<Client> clients = empresa.getLlistaClients();
    
        while (!correcte) {
            System.out.println("Introdueix el dni: ");
            dni = scanner.nextLine();
            boolean dniExiste = false;
    
            if(type == 1){
                for (Empleat empleat : empleats) {
                    if (empleat.getDni().equals(dni)) {
                        dniExiste = true;
                        break;
                    }
                }
            } else {
                for (Client client : clients) {
                    if (client.getDni().equals(dni)) {
                        dniExiste = true;
                        break;
                    }
                }
            }
    
            if (!dniExiste) {
                correcte = true;
            }
    
            if (dniExiste) {
                System.out.println("DNI ya registrat, prova de nou.");
            }
        }
    
        return dni;
    }    

    // FUNCIONES PARA SELECCIONAR LOS PARAMETROS DE UN NUEVO LLOGUER
    public String selecciona_data_inici(Scanner scanner){
        String data_inici = "";
        boolean correcte = false;

        while(!correcte){
            System.out.println("Introdueix la data d'inici (YYYY-MM-DD): ");
            data_inici = scanner.nextLine();

            // Intentar parsear la fecha
            try {
                // Intentamos parsear la fecha
                LocalDate date = LocalDate.parse(data_inici, DateTimeFormatter.ISO_LOCAL_DATE);
                correcte = true; // Si la fecha es válida, salimos del bucle
            } catch (DateTimeParseException e) {
                // Si la fecha no es válida, mostramos un mensaje de error
                System.out.println("Data no vàlida, prova de nou. Format correcte: YYYY-MM-DD");
            }
        }

        return data_inici;
    }

    public String selecciona_data_final(Scanner scanner, String data_inici){
        String data_final = "";
        boolean correcte = false;
    
        // Parseamos la fecha de inicio
        LocalDate fecha_inici = LocalDate.parse(data_inici, DateTimeFormatter.ISO_LOCAL_DATE);
    
        while(!correcte){
            System.out.println("Introdueix la data de fi (YYYY-MM-DD): ");
            data_final = scanner.nextLine();
    
            // Intentar parsear la fecha de fin
            try {
                // Intentamos parsear la fecha
                LocalDate fecha_fin = LocalDate.parse(data_final, DateTimeFormatter.ISO_LOCAL_DATE);
    
                // Comprobamos que la fecha final es posterior a la de inicio
                if (fecha_fin.isAfter(fecha_inici)) {
                    correcte = true; // Si la fecha es válida y posterior a la de inicio, salimos del bucle
                } else {
                    System.out.println("La data de fi ha de ser posterior a la data d'inici. Prova de nou.");
                }
    
            } catch (DateTimeParseException e) {
                // Si la fecha no es válida, mostramos un mensaje de error
                System.out.println("Data no vàlida, prova de nou. Format correcte: YYYY-MM-DD");
            }
        }
    
        return data_final;
    }

    public String selecciona_vehicle(Scanner scanner, boolean nomes_disponibles){
        String matricula = "";
        boolean correcte = false;
        List<Vehicle> vehicles = empresa.getLlistaVehicles();

        while (!correcte){
            mostrar_vehicles(nomes_disponibles); // Mostrar la lista de vehículos (esto dependerá de tu implementación)
            System.out.println("Introdueix la matricula del vehicle: ");
            matricula = scanner.nextLine();
    
            // Verificar si la matrícula existe en la lista de vehículos
            for (Vehicle v : vehicles) {
                if (v.getMatricula().equals(matricula)) {
                    correcte = true; // Si la matrícula existe, es correcto
                    break; // Salir del bucle una vez encontrada la matrícula
                }
            }
    
            // Si no se encontró la matrícula, informar al usuario
            if (!correcte) {
                System.out.println("Matricula no válida, prova de nou.");
            }
        }

        return matricula;
    }

    public String selecciona_client(Scanner scanner, boolean nomes_disponibles){
        String dni = "";
        boolean correcte = false;
        List<Client> clients = empresa.getLlistaClients();

        while (!correcte){
            mostrar_clients(nomes_disponibles); 
            System.out.println("Introdueix el DNI del client: ");
            dni = scanner.nextLine();
            for (Client c : clients) {
                if (c.getDni().equals(dni)) {
                    correcte = true;
                    break;
                }
            }
    
            if (!correcte) {
                System.out.println("dni no válid, prova de nou.");
            }
        }

        return dni;
    }

    public String selecciona_empleat(Scanner scanner, boolean nomes_disponibles ){
        String dni = "";
        boolean correcte = false;
        List<Empleat> empleats = empresa.getLlistaEmpleats();

        while (!correcte){
            mostrar_empleats(nomes_disponibles); 
            System.out.println("Introdueix el DNI de l'Empleat: ");
            dni = scanner.nextLine();
            for (Empleat e : empleats) {
                if (e.getDni().equals(dni)) {
                    correcte = true;
                    break;
                }
            }
    
            if (!correcte) {
                System.out.println("dni no válid, prova de nou.");
            }
        }

        return dni;
    }

    // FUNCIONES PARA MOSTRAR LAS LISTAS DE LOS OBJETOS
    public void mostrar_vehicles(boolean nomes_disponibles){
        List<Vehicle> vehicles = empresa.getLlistaVehicles();
        if (vehicles != null) {
            for(Vehicle empleat : vehicles){
                System.out.println(empleat.toString());
            }
        }         
    }
    public void mostrar_empleats(boolean nomes_disponibles){
        List<Empleat> empleats = empresa.getLlistaEmpleats();
        if (empleats != null) {
            for(Empleat empleat : empleats){
                System.out.println(empleat.toString());
            }
        }         
    }
    public void mostrar_clients(boolean nomes_disponibles){
        List<Client> clients = empresa.getLlistaClients();
        if (clients != null) {
            for(Client client : clients){
                System.out.println(client.toString());
            }
        }         
    }
    public void mostrar_lloguers(boolean nomes_disponibles){
        List<Lloguer> lloguers = empresa.getLlistaLloguers();
        if (lloguers != null) {
            for(Lloguer lloguer : lloguers){
                System.out.println(lloguer.toString());
            }
        }         
    }

    public void guardarNouLloguer(String matricula_vehicle, String dni_client, String dni_empleat, String data_inici, String data_final){
            
        Vehicle vehicleSeleccionat = empresa.getLlistaVehicles().stream()
        .filter(v -> v.getMatricula().equalsIgnoreCase(matricula_vehicle))
        .findFirst().orElse(null);

        Client clientSeleccionat = empresa.getLlistaClients().stream()
            .filter(c -> c.getDni().equalsIgnoreCase(dni_client))
            .findFirst().orElse(null);

        Empleat empleatSeleccionat = empresa.getLlistaEmpleats().stream()
            .filter(e -> e.getDni().equalsIgnoreCase(dni_empleat))
            .findFirst().orElse(null);

        if (vehicleSeleccionat == null){
            System.out.println("Error: No s'ha trobat el Vehicle.");
            return;
        } else if (clientSeleccionat == null){
            System.out.println("Error: No s'ha trobat el Client.");
            return;
        } else if (empleatSeleccionat == null) {
            System.out.println("Error: No s'ha trobat l'empleat.");
            return;
        }

        int nouId = empresa.getLlistaLloguers().stream()
            .mapToInt(Lloguer::getId)
            .max().orElse(0) + 1;

        Lloguer nouLloguer = new Lloguer(nouId, clientSeleccionat, empleatSeleccionat, vehicleSeleccionat, data_inici, data_final);
        empresa.getLlistaLloguers().add(nouLloguer);
    }

    public void modificar_vehicle(Scanner scanner){
        String matricula = selecciona_vehicle(scanner, false);
    
        Vehicle vehicleSeleccionat = empresa.getLlistaVehicles().stream()
            .filter(v -> v.getMatricula().equalsIgnoreCase(matricula))
            .findFirst().orElse(null);
    
        if (vehicleSeleccionat == null) {
            System.out.println("Vehicle no trobat.");
            return;
        }
    
        boolean sortir = false;
    
        while (!sortir) {
            System.out.println("""
                ------- MODIFICAR VEHICLE -------
                1. Kilometratge actual:   %d
                2. Vegades llogat:        %d
                3. Marca:                 %s
                4. Model:                 %s
                5. Matrícula:             %s
                6. Preu per dia:          %.2f
                7. Estat de lloguer:      %s
                0. Sortir i guardar canvis
                """.formatted(
                    vehicleSeleccionat.getKilometratge(),
                    vehicleSeleccionat.getVegades_llogat(),
                    vehicleSeleccionat.getMarca(),
                    vehicleSeleccionat.getModel(),
                    vehicleSeleccionat.getMatricula(),
                    vehicleSeleccionat.getPreu_dia(),
                    vehicleSeleccionat.isEsta_llogat() ? "Llogat" : "Disponible"
                )
            );
    
            System.out.print("Escull una opció per modificar: ");
            int opcio = scanner.nextInt();
            scanner.nextLine(); // Neteja de buffer
    
            switch (opcio) {
                case 1 -> {
                    System.out.print("Nou kilometratge: ");
                    int nouKm = scanner.nextInt();
                    scanner.nextLine();
                    vehicleSeleccionat.setKilometratge(nouKm);
                }
                case 2 -> {
                    System.out.print("Nou nombre de vegades llogat: ");
                    int vegades = scanner.nextInt();
                    scanner.nextLine();
                    vehicleSeleccionat.setVegades_llogat(vegades);
                }
                case 3 -> {
                    System.out.print("Nova marca: ");
                    String marca = scanner.nextLine();
                    vehicleSeleccionat.setMarca(marca);
                }
                case 4 -> {
                    System.out.print("Nou model: ");
                    String model = scanner.nextLine();
                    vehicleSeleccionat.setModel(model);
                }
                case 5 -> {
                    System.out.println("Nova matrícula: ");
                    String novaMatricula = agrega_matricula(scanner);
                    vehicleSeleccionat.setMatricula(novaMatricula);
                }
                case 6 -> {
                    System.out.print("Nou preu per dia: ");
                    double preu = scanner.nextDouble();
                    scanner.nextLine();
                    vehicleSeleccionat.setPreu_dia(preu);
                }
                case 7 -> {
                    System.out.print("Està llogat? (true/false): ");
                    boolean estaLlogat = scanner.nextBoolean();
                    scanner.nextLine();
                    vehicleSeleccionat.setEsta_llogat(estaLlogat);
                }
                case 0 -> {
                    sortir = true;
                    System.out.println("Canvis guardats.");
                }
                default -> System.out.println("Opció invàlida. Torna-ho a intentar.");
            }
        }
    }
    
    public void modificar_client(Scanner scanner) {
        String dni = selecciona_client(scanner, false);
    
        Client clientSeleccionat = empresa.getLlistaClients().stream()
            .filter(c -> c.getDni().equalsIgnoreCase(dni))
            .findFirst().orElse(null);
    
        if (clientSeleccionat == null) {
            System.out.println("Client no trobat.");
            return;
        }
    
        boolean sortir = false;
    
        while (!sortir) {
            System.out.println("""
                ------- MODIFICAR CLIENT -------
                1. Nom:                  %s
                2. Cognom:               %s
                3. DNI:                  %s
                4. Sexe:                 %s
                5. Edat:                 %d
                6. Telèfon:              %d
                7. Vegades lloguer:      %d
                8. Té lloguer actiu:     %s
                0. Sortir i guardar canvis
                """.formatted(
                    clientSeleccionat.getNom(),
                    clientSeleccionat.getCognom(),
                    clientSeleccionat.getDni(),
                    clientSeleccionat.getSexe(),
                    clientSeleccionat.getEdat(),
                    clientSeleccionat.getNum_telf(),
                    clientSeleccionat.getVegades_lloguer(),
                    clientSeleccionat.isTe_lloguer() ? "Sí" : "No"
                )
            );
    
            System.out.print("Escull una opció per modificar: ");
            int opcio = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcio) {
                case 1 -> {
                    System.out.print("Nou nom: ");
                    clientSeleccionat.setNom(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Nou cognom: ");
                    clientSeleccionat.setCognom(scanner.nextLine());
                }
                case 3 -> {
                    System.out.print("Nou DNI: ");
                    clientSeleccionat.setDni(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Nou sexe: ");
                    clientSeleccionat.setSexe(scanner.nextLine());
                }
                case 5 -> {
                    System.out.print("Nova edat: ");
                    clientSeleccionat.setEdat(scanner.nextInt());
                    scanner.nextLine();
                }
                case 6 -> {
                    System.out.print("Nou telèfon: ");
                    clientSeleccionat.setNum_telf(scanner.nextInt());
                    scanner.nextLine();
                }
                case 7 -> {
                    System.out.print("Nou nombre de vegades llogat: ");
                    clientSeleccionat.setVegades_lloguer(scanner.nextInt());
                    scanner.nextLine();
                }
                case 8 -> {
                    System.out.print("Té lloguer actiu? (true/false): ");
                    clientSeleccionat.setTe_lloguer(scanner.nextBoolean());
                    scanner.nextLine();
                }
                case 0 -> {
                    sortir = true;
                    System.out.println("Canvis guardats.");
                }
                default -> System.out.println("Opció invàlida.");
            }
        }
    }
    
    public void modificar_empleat(Scanner scanner) {
        String dni = selecciona_empleat(scanner, false);
    
        Empleat empleatSeleccionat = empresa.getLlistaEmpleats().stream()
            .filter(e -> e.getDni().equalsIgnoreCase(dni))
            .findFirst().orElse(null);
    
        if (empleatSeleccionat == null) {
            System.out.println("Empleat no trobat.");
            return;
        }
    
        boolean sortir = false;
    
        while (!sortir) {
            System.out.println("""
                ------- MODIFICAR EMPLEAT -------
                1. Nom:                %s
                2. Cognom:             %s
                3. DNI:                %s
                4. Sexe:               %s
                5. Edat:               %d
                6. Telèfon:            %d
                7. Càrrec:             %s
                8. Anys a l'empresa:   %d
                9. Està contractat:    %s
                0. Sortir i guardar canvis
                """.formatted(
                    empleatSeleccionat.getNom(),
                    empleatSeleccionat.getCognom(),
                    empleatSeleccionat.getDni(),
                    empleatSeleccionat.getSexe(),
                    empleatSeleccionat.getEdat(),
                    empleatSeleccionat.getNum_telf(),
                    empleatSeleccionat.getCarrec(),
                    empleatSeleccionat.getAnys_empresa(),
                    empleatSeleccionat.isContractat() ? "Sí" : "No"
                )
            );
    
            System.out.print("Escull una opció per modificar: ");
            int opcio = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcio) {
                case 1 -> {
                    System.out.print("Nou nom: ");
                    empleatSeleccionat.setNom(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Nou cognom: ");
                    empleatSeleccionat.setCognom(scanner.nextLine());
                }
                case 3 -> {
                    System.out.print("Nou DNI: ");
                    empleatSeleccionat.setDni(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Nou sexe: ");
                    empleatSeleccionat.setSexe(scanner.nextLine());
                }
                case 5 -> {
                    System.out.print("Nova edat: ");
                    empleatSeleccionat.setEdat(scanner.nextInt());
                    scanner.nextLine();
                }
                case 6 -> {
                    System.out.print("Nou telèfon: ");
                    empleatSeleccionat.setNum_telf(scanner.nextInt());
                    scanner.nextLine();
                }
                case 7 -> {
                    System.out.print("Nou càrrec: ");
                    empleatSeleccionat.setCarrec(scanner.nextLine());
                }
                case 8 -> {
                    System.out.print("Nous anys a l'empresa: ");
                    empleatSeleccionat.setAnys_empresa(scanner.nextInt());
                    scanner.nextLine();
                }
                case 9 -> {
                    System.out.print("Està contractat? (true/false): ");
                    empleatSeleccionat.setContractat(scanner.nextBoolean());
                    scanner.nextLine();
                }
                case 0 -> {
                    sortir = true;
                    System.out.println("Canvis guardats.");
                }
                default -> System.out.println("Opció invàlida.");
            }
        }
    }
    
    public void modificar_lloguer(Scanner scanner) {
        mostrar_lloguers(false);
        System.out.print("Introdueix l'ID del lloguer a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        Lloguer lloguer = empresa.getLlistaLloguers().stream()
            .filter(l -> l.getId() == id)
            .findFirst().orElse(null);
    
        if (lloguer == null) {
            System.out.println("Lloguer no trobat.");
            return;
        }
    
        boolean sortir = false;
    
        while (!sortir) {
            System.out.println("""
                ------- MODIFICAR LLOGUER -------
                1. Vehicle (matrícula):      %s
                2. Client (DNI):             %s
                3. Empleat (DNI):            %s
                4. Data inici:               %s
                5. Data final:               %s
                0. Sortir i guardar canvis
                """.formatted(
                    lloguer.getVehicle().getMatricula(),
                    lloguer.getClient().getDni(),
                    lloguer.getEmpleat().getDni(),
                    lloguer.getDataInici(),
                    lloguer.getDataFi()
                )
            );
    
            System.out.print("Escull una opció per modificar: ");
            int opcio = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcio) {
                case 1 -> {
                    mostrar_vehicles(false);
                    System.out.print("Nou vehicle (Introdueix la matricula): ");
                    String novaMatricula = scanner.nextLine();
                    Vehicle nouVehicle = empresa.getLlistaVehicles().stream()
                        .filter(v -> v.getMatricula().equalsIgnoreCase(novaMatricula))
                        .findFirst().orElse(null);
    
                    if (nouVehicle != null) {
                        lloguer.setVehicle(nouVehicle);
                    } else {
                        System.out.println("Vehicle no trobat.");
                    }
                }
    
                case 2 -> {
                    mostrar_clients(false);
                    System.out.print("Nou client (Introdueix el DNI): ");
                    String nouDniClient = scanner.nextLine();
                    Client nouClient = empresa.getLlistaClients().stream()
                        .filter(c -> c.getDni().equalsIgnoreCase(nouDniClient))
                        .findFirst().orElse(null);
    
                    if (nouClient != null) {
                        lloguer.setClient(nouClient);
                    } else {
                        System.out.println("Client no trobat.");
                    }
                }
    
                case 3 -> {
                    mostrar_empleats(false);
                    System.out.print("Nou empleat (Introdueix el DNI): ");
                    String nouDniEmpleat = scanner.nextLine();
                    Empleat nouEmpleat = empresa.getLlistaEmpleats().stream()
                        .filter(e -> e.getDni().equalsIgnoreCase(nouDniEmpleat))
                        .findFirst().orElse(null);
    
                    if (nouEmpleat != null) {
                        lloguer.setEmpleat(nouEmpleat);
                    } else {
                        System.out.println("Empleat no trobat.");
                    }
                }
    
                case 4 -> {
                    System.out.print("Nova data d'inici: ");
                    String novaDataInici = selecciona_data_inici(scanner);
                    lloguer.setDataInici(novaDataInici);
                }
    
                case 5 -> {
                    System.out.print("Nova data final: ");
                    String dataIniciActual = lloguer.getDataInici().toString();
                    String novaDataFinal = selecciona_data_final(scanner, dataIniciActual);
                    lloguer.setDataFi(novaDataFinal);
                }
    
                case 0 -> {
                    sortir = true;
                    System.out.println("Canvis guardats.");
                }
    
                default -> System.out.println("Opció invàlida.");
            }
        }
    }
}
