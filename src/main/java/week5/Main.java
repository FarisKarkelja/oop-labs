package week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("BMW", 130000, 99);
        Vehicle truck = new Truck("Scania", 313000, 78);
        Vehicle motorcycle = new Motorcycle("Yamaha", 84000, 65);

        Collections.addAll(vehicles, car, truck, motorcycle);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            vehicle.simulateYear();
        }

        downcasting(car);
        downcasting(truck);
        downcasting(motorcycle);

        Scanner input = new Scanner(System.in);
        System.out.println("Select a vehicle for maintenance (0 - car, 1 - truck, 2 - motorcycle): ");
        int choice = Integer.parseInt(input.nextLine());

        if (choice >= 0 && choice < vehicles.size()) {
            Vehicle selectedVehicle = vehicles.get(choice);
            selectedVehicle.performMaintenance(selectedVehicle);
            System.out.println("Maintenance was successfully performed.");
        } else {
            System.out.println("Invalid choice.");
        }

        input.close();
    }

    public static void downcasting(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car localCar = (Car) vehicle;
            localCar.drive(320);
        } else if (vehicle instanceof Truck) {
            Truck localTruck = (Truck) vehicle;
            localTruck.haul(1400);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle localMotorcycle = (Motorcycle) vehicle;
            localMotorcycle.race(750);
        } else {
            System.out.println("Unknown vehicle type.");
        }
    }

}

