package com.project;

import java.util.ArrayList;
import java.util.List;

import com.project.Classes.Empleat;
import com.project.Classes.Client;
import com.project.Classes.Vehicle;
import com.project.Classes.Lloguer;

public class Main {
    public static void main(String[] args) {

        List<Empleat> llistaEmpleats = new ArrayList<>();
        List<Client> llistaClients = new ArrayList<>();
        List<Vehicle> llistaVehicles = new ArrayList<>();
        List<Lloguer> llistaLloguers = new ArrayList<>();

        // Agregar 10 Clientes
        llistaClients.add(new Client("Home", "Marc", "Castro", "12345678Z", 11, 612345679, 32, 5, false));
        llistaClients.add(new Client("Dona", "Elena", "Giménez", "23456789X", 12, 622345679, 29, 2, true));
        llistaClients.add(new Client("Home", "Jordi", "Martínez", "34567890Y", 13, 632345679, 41, 7, false));
        llistaClients.add(new Client("Dona", "Laura", "Fernández", "45678901W", 14, 642345679, 25, 3, false));
        llistaClients.add(new Client("Home", "Pere", "Vilaplana", "56789012V", 15, 652345679, 38, 8, true));
        llistaClients.add(new Client("Dona", "Maria", "Sánchez", "67890123U", 16, 662345679, 27, 1, false));
        llistaClients.add(new Client("Home", "Albert", "Torres", "78901234T", 17, 672345679, 50, 10, true));
        llistaClients.add(new Client("Dona", "Clara", "Ortega", "89012345S", 18, 682345679, 31, 6, false));
        llistaClients.add(new Client("Home", "Ricard", "López", "90123456R", 19, 692345679, 45, 4, true));
        llistaClients.add(new Client("Dona", "Sara", "Navarro", "01234567Q", 20, 602345679, 22, 2, false));

        // Agregar 5 Empleados
        llistaEmpleats.add(new Empleat("Home", "Francesc", "Puig", "12345678M", 21, 612345680, 45, "Venedor", 15, true));
        llistaEmpleats.add(new Empleat("Dona", "Teresa", "Sola", "23456789N", 22, 622345680, 34, "Venedor", 8, true));
        llistaEmpleats.add(new Empleat("Home", "Xavier", "Ferrer", "34567890P", 23, 632345680, 40, "Venedor", 12, true));
        llistaEmpleats.add(new Empleat("Dona", "Núria", "Blasco", "45678901O", 24, 642345680, 28, "Venedor", 5, true));
        llistaEmpleats.add(new Empleat("Home", "Joan", "Serra", "56789012N", 25, 652345680, 37, "Venedor", 10, true));

        // Agregar 5 vehicles
        llistaVehicles.add(new Vehicle(101, 50000, 10, "Toyota", "Cotxe", "1234ABC", 35.5f, false));
        llistaVehicles.add(new Vehicle(102, 30000, 5, "Ford", "Cotxe", "2345BCD", 40.0f, true));
        llistaVehicles.add(new Vehicle(103, 15000, 3, "BMW", "Cotxe", "3456CDE", 75.0f, false));
        llistaVehicles.add(new Vehicle(104, 25000, 7, "Audi", "Cotxe", "4567DEF", 60.0f, true));
        llistaVehicles.add(new Vehicle(105, 10000, 2, "Mercedes", "Cotxe", "5678EFG", 80.0f, false));
        llistaVehicles.add(new Vehicle(106, 40000, 12, "Harley-Davidson", "Moto", "6789FGH", 30.0f, true));
        llistaVehicles.add(new Vehicle(107, 5000, 1, "Yamaha", "Moto", "7890GHI", 45.0f, false));
        llistaVehicles.add(new Vehicle(108, 20000, 4, "Kawasaki", "Moto", "8901HIJ", 50.0f, true));
        llistaVehicles.add(new Vehicle(109, 60000, 15, "Suzuki", "Moto", "9012IJK", 55.0f, false));
        llistaVehicles.add(new Vehicle(110, 8000, 2, "Honda", "Moto", "0123JKL", 32.5f, true));

        // Crear 10 alquileres (Lloguer)
        llistaLloguers.add(new Lloguer(1, llistaClients.get(0), llistaEmpleats.get(0), llistaVehicles.get(0), "2024-03-01", "2024-03-07"));
        llistaLloguers.add(new Lloguer(2, llistaClients.get(1), llistaEmpleats.get(1), llistaVehicles.get(1), "2024-02-15", "2024-02-20"));
        llistaLloguers.add(new Lloguer(3, llistaClients.get(2), llistaEmpleats.get(2), llistaVehicles.get(2), "2024-01-10", "2024-01-17"));
        llistaLloguers.add(new Lloguer(4, llistaClients.get(3), llistaEmpleats.get(3), llistaVehicles.get(3), "2024-03-10", "2024-03-15"));
        llistaLloguers.add(new Lloguer(5, llistaClients.get(4), llistaEmpleats.get(4), llistaVehicles.get(4), "2024-02-01", "2024-02-05"));
        llistaLloguers.add(new Lloguer(6, llistaClients.get(5), llistaEmpleats.get(0), llistaVehicles.get(5), "2024-01-05", "2024-01-12"));
        llistaLloguers.add(new Lloguer(7, llistaClients.get(6), llistaEmpleats.get(1), llistaVehicles.get(6), "2024-02-18", "2024-02-22"));
        llistaLloguers.add(new Lloguer(8, llistaClients.get(7), llistaEmpleats.get(2), llistaVehicles.get(7), "2024-03-05", "2024-03-09"));
        llistaLloguers.add(new Lloguer(9, llistaClients.get(8), llistaEmpleats.get(3), llistaVehicles.get(8), "2024-01-28", "2024-02-03"));
        llistaLloguers.add(new Lloguer(10, llistaClients.get(9), llistaEmpleats.get(4), llistaVehicles.get(9), "2024-02-10", "2024-02-14"));

        // Mostrar los clientes
        System.out.println("=== Llista de Clients ===");
        for (Client client : llistaClients) {
            System.out.println(client.toString());
        }

        // Mostrar los empleados
        System.out.println("=== Llista de Empleats ===");
        for (Empleat empleat : llistaEmpleats) {
            System.out.println(empleat.toString());
        }

        // Mostrar los vehículos
        System.out.println("=== Llista de Vehicles ===");
        for (Vehicle vehicle : llistaVehicles) {
            System.out.println(vehicle.toString());
        }

        // Mostrar los alquileres
        System.out.println("=== Llista de Lloguers ===");
        for (Lloguer lloguer : llistaLloguers) {
            System.out.println(lloguer.toString());
        }

    }
    
}