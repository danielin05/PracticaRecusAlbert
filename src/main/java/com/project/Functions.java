package com.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.project.Classes.Client;
import com.project.Classes.Empleat;
import com.project.Classes.Lloguer;
import com.project.Classes.Vehicle;

public class Functions {

    // ========= MENUS =========
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
        System.out.println(menu_nous);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Nou Lloguer seleccionat");
                nou_lloguer(scanner);
                // Aquí iría la lógica para agregar un nuevo alquiler
                break;
            case "2":
                System.out.println("Nou Vehicle seleccionat");
                // Aquí iría la lógica para agregar un nuevo vehículo
                break;
            case "3":
                System.out.println("Nou Empleat seleccionat");
                // Aquí iría la lógica para agregar un nuevo empleado
                break;
            case "4":
                System.out.println("Nou Client seleccionat");
                // Aquí iría la lógica para agregar un nuevo cliente
                break;
            case "5":
                System.out.println("Tornant al menú principal");
                break;
            default:
                System.out.println("Opció invàlida. Prova-ho de nou.");
        }
        scanner.nextLine();  // Limpiar el buffer
    }

    // Método para manejar el menú de mostrar registros
    public void gestio_mostrar(Scanner scanner) {
        System.out.println(menu_mostrar);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Mostrar Lloguers");
                // Aquí iría la lógica para mostrar los alquileres
                break;
            case "2":
                System.out.println("Mostrar Vehicles");
                // Aquí iría la lógica para mostrar los vehículos
                break;
            case "3":
                System.out.println("Mostrar Empleats");
                // Aquí iría la lógica para mostrar los empleados
                break;
            case "4":
                System.out.println("Mostrar Clients");
                // Aquí iría la lógica para mostrar los clientes
                break;
            case "5":
                System.out.println("Tornant al menú principal");
                break;
            default:
                System.out.println("Opció invàlida. Prova-ho de nou.");
        }
        scanner.nextLine();  // Limpiar el buffer
    }

    // Método para manejar el menú de modificar registros
    public void gestio_modificar(Scanner scanner) {
        System.out.println(menu_modificar);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Modificar Lloguer");
                // Aquí iría la lógica para modificar un alquiler
                break;
            case "2":
                System.out.println("Modificar Vehicle");
                // Aquí iría la lógica para modificar un vehículo
                break;
            case "3":
                System.out.println("Modificar Empleat");
                // Aquí iría la lógica para modificar un empleado
                break;
            case "4":
                System.out.println("Modificar Client");
                // Aquí iría la lógica para modificar un cliente
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

        String matricula_vehicle = selecciona_vehicle(scanner);

        //INSERTAR FUNCION QUE MUESTRA LOS CLIENTES SIN ALQUILER
        System.out.println("Introdueix el DNI del client: ");
        String dni_client = scanner.nextLine();

        //INSERTAR FUNCION QUE MUESTRA LOS EMPLEADOS CONTRATADOS
        System.out.println("Introdueix el DNI de l'empleat: ");
        String dni_empleat = scanner.nextLine();

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
            System.out.println("Guardant el nou lloguer.");
            //FUNCION PARA AGREGAR AL JSON Y GUARDAR EL NUEVO LLOGUER
        }else{
            System.out.println("NO se guardara el nou lloguer, tornant enrere.");
        }
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

    public String selecciona_vehicle(Scanner scanner){
        String matricula = "";
        boolean correcte = false;
        boolean nomes_disponibles = true;
        List<Vehicle> vehicles = carregar_vehicles(nomes_disponibles);

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

    // // FUNCIONES PARA MOSTRAR LAS LISTAS DE LOS OBJETOS
    // public void mostrar_vehicles(boolean nomes_disponibles){
    //     List<Vehicle> vehicles = carregar_vehicles(nomes_disponibles);
    //     if (vehicles != null) {
    //         for(Vehicle empleat : vehicles){
    //             System.out.println(empleat.toString());
    //         }
    //     }         
    // }
    // public void mostrar_empleats(boolean nomes_disponibles){
    //     List<Empleat> empleats = carregar_empleats(nomes_disponibles);
    //     if (empleats != null) {
    //         for(Empleat empleat : empleats){
    //             System.out.println(empleat.toString());
    //         }
    //     }         
    // }
    // public void mostrar_clients(boolean nomes_disponibles){
    //     List<Client> clients = carregar_clients(nomes_disponibles);
    //     if (clients != null) {
    //         for(Client client : clients){
    //             System.out.println(client.toString());
    //         }
    //     }         
    // }
    // public void mostrar_lloguers(boolean nomes_disponibles){
    //     List<Lloguer> lloguers = carregar_lloguers(nomes_disponibles);
    //     if (lloguers != null) {
    //         for(Lloguer lloguer : lloguers){
    //             System.out.println(lloguer.toString());
    //         }
    //     }         
    // }

}
