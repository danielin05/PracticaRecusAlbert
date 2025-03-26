package com.project;

import java.util.Scanner;

public class Main {
    // ========= Variables =========
    private boolean exit = false;

    // ========= MENUS =========
    String menu_base = 
    """
    ---------- MENU PRINCIPAL ----------
    1) Nou Registre
    2) Mostrar Registres
    3) Modificar Registres
    4) Sortir
    """;

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
    private void gestio_nous(Scanner scanner) {
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
    private void gestio_mostrar(Scanner scanner) {
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
    private void gestio_modificar(Scanner scanner) {
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

        System.out.println("Introdueix la data d'inici (YYYY-MM-DD): ");
        String data_inici = scanner.nextLine();

        System.out.println("Introdueix la data de fi (YYYY-MM-DD): ");
        String data_final = scanner.nextLine();

        //INSERTAR FUNCION QUE MUESTRA LOS VEHICULOS DISPONIBLES
        System.out.println("Introdueix la matricula del vehicle: ");
        String matricula_vehicle = scanner.nextLine();

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
            System.out.println("Guardant el nuy lloguer.");
            //FUNCION PARA AGREGAR AL JSON Y GUARDAR EL NUEVO LLOGUER
        }else{
            System.out.println("NO se guardara el nou lloguer, tornant enrere.");
        }
    }



    // ========== FUNCIONALIDAD DEL PROGRAMA ==========

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        // Mostrar el menú base
        while (!exit) {
            System.out.println(menu_base);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    gestio_nous(scanner);
                    break;
                case "2":
                    gestio_mostrar(scanner);
                    break;
                case "3":
                    gestio_modificar(scanner);
                    break;
                case "4":
                    System.out.println("Sortint...");
                    exit = true;  // Salir del bucle
                    break;
                default:
                    System.out.println("Opció invàlida. Prova-ho de nou.");
            }
            scanner.nextLine();  // Limpiar el buffer
        }
        scanner.close();
    }
}