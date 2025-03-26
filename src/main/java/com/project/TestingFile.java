package com.project;

import java.util.ArrayList;
import java.util.List;

import com.project.Classes.Client;
import com.project.Classes.Empleat;
import com.project.Classes.Empresa;
import com.project.Classes.Lloguer;
import com.project.Classes.Vehicle;

public class TestingFile {
    
    public static void main(String[] args) {

        List<Empleat> llistaEmpleats = new ArrayList<>();
        List<Client> llistaClients = new ArrayList<>();
        List<Vehicle> llistaVehicles = new ArrayList<>();
        List<Lloguer> llistaLloguers = new ArrayList<>();
        Empresa empresa = new Empresa();

        // Agregar 10 Clientes
        llistaClients.add(new Client("Home", "Marc", "Castro", "12345678Z", 1, 612345679, 32, 5, false));
        llistaClients.add(new Client("Dona", "Elena", "Giménez", "23456789X", 2, 622345679, 29, 2, true));
        llistaClients.add(new Client("Home", "Jordi", "Martínez", "34567890Y", 3, 632345679, 41, 7, false));
        llistaClients.add(new Client("Dona", "Laura", "Fernández", "45678901W", 4, 642345679, 25, 3, false));
        llistaClients.add(new Client("Home", "Pere", "Vilaplana", "56789012V", 5, 652345679, 38, 8, true));
        llistaClients.add(new Client("Dona", "Maria", "Sánchez", "67890123U", 6, 662345679, 27, 1, false));
        llistaClients.add(new Client("Home", "Albert", "Torres", "78901234T", 7, 672345679, 50, 10, true));
        llistaClients.add(new Client("Dona", "Clara", "Ortega", "89012345S", 8, 682345679, 31, 6, false));
        llistaClients.add(new Client("Home", "Ricard", "López", "90123456R", 9, 692345679, 45, 4, true));
        llistaClients.add(new Client("Dona", "Sara", "Navarro", "01234567Q", 10, 602345679, 22, 2, false));

        // Agregar 5 Empleados
        llistaEmpleats.add(new Empleat("Home", "Francesc", "Puig", "12345678M", 1, 612345680, 45, "Venedor", 15, true));
        llistaEmpleats.add(new Empleat("Dona", "Teresa", "Sola", "23456789N", 2, 622345680, 34, "Venedor", 8, true));
        llistaEmpleats.add(new Empleat("Home", "Xavier", "Ferrer", "34567890P", 3, 632345680, 40, "Venedor", 12, true));
        llistaEmpleats.add(new Empleat("Dona", "Núria", "Blasco", "45678901O", 4, 642345680, 28, "Venedor", 5, true));
        llistaEmpleats.add(new Empleat("Home", "Joan", "Serra", "56789012N", 5, 652345680, 37, "Venedor", 10, true));

        // Agregar 10 vehicles
        llistaVehicles.add(new Vehicle(1, 50000, 10, "Toyota", "Cotxe", "1234ABC", 35.5f, false));
        llistaVehicles.add(new Vehicle(2, 30000, 5, "Ford", "Cotxe", "2345BCD", 40.0f, true));
        llistaVehicles.add(new Vehicle(3, 15000, 3, "BMW", "Cotxe", "3456CDE", 75.0f, false));
        llistaVehicles.add(new Vehicle(4, 25000, 7, "Audi", "Cotxe", "4567DEF", 60.0f, true));
        llistaVehicles.add(new Vehicle(5, 10000, 2, "Mercedes", "Cotxe", "5678EFG", 80.0f, false));
        llistaVehicles.add(new Vehicle(6, 40000, 12, "Harley-Davidson", "Moto", "6789FGH", 30.0f, true));
        llistaVehicles.add(new Vehicle(7, 5000, 1, "Yamaha", "Moto", "7890GHI", 45.0f, false));
        llistaVehicles.add(new Vehicle(8, 20000, 4, "Kawasaki", "Moto", "8901HIJ", 50.0f, true));
        llistaVehicles.add(new Vehicle(9, 60000, 15, "Suzuki", "Moto", "9012IJK", 55.0f, false));
        llistaVehicles.add(new Vehicle(10, 8000, 2, "Honda", "Moto", "0123JKL", 32.5f, true));

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

        empresa.setLlistaClients(llistaClients);
        empresa.setLlistaEmpleats(llistaEmpleats);
        empresa.setLlistaLloguers(llistaLloguers);
        empresa.setLlistaVehicles(llistaVehicles);

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

        System.out.println("=== EMPRESA ===");
        System.out.println(empresa);
    }
}
