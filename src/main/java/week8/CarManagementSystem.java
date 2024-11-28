package week8;

import java.util.*;

enum CarType {
    SEDAN, SUV, TRUCK, VAN, SPORTS
}

interface Rentable {
    double applyDiscount(double discountRate);

    String getDescription();
}

abstract class Vehicle implements Rentable {
    private String vehicleId;
    private String name;
    private double rentalRate;
    private Map<Date, Integer> kilometersRecord;

    public Vehicle(String vehicleId, String name, double rentalRate) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.rentalRate = rentalRate;
        this.kilometersRecord = new HashMap<>();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void addKilometers(Date rentalDate, int kilometers) {
        kilometersRecord.put(rentalDate, kilometers);
    }

    public int getTotalKilometers() {
        int total = 0;
        for (Date date : kilometersRecord.keySet()) {
            total += kilometersRecord.get(date);
        }
        return total;
    }

    @Override
    public double applyDiscount(double discountRate) {
        return rentalRate - (rentalRate * discountRate);
    }

    @Override
    public String getDescription() {
        return "ID: " + vehicleId + "\nName: " + name + "\nRental rate: " + rentalRate;
    }
}

class Car extends Vehicle {
    private CarType carType;
    private String engineType;

    public Car(String vehicleId, String name, double rentalRate,
               CarType carType, String engineType) {
        super(vehicleId, name, rentalRate);
        this.carType = carType;
        this.engineType = engineType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nType: " + carType +
                "\nEngine: " + engineType;
    }
}

class Motorcycle extends Vehicle {
    private double engineCapacity;

    public Motorcycle(String vehicleId, String name, double
            rentalRate, double engineCapacity) {
        super(vehicleId, name, rentalRate);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacity: " + engineCapacity;
    }
}

class RentalTransaction<T extends Vehicle & Rentable> {
    private String transactionId;
    private Date rentalDate;
    private Map<T, Integer> rentedVehicles;
    private int customerId;

    public RentalTransaction(String transactionId, Date rentalDate,
                             int customerId) {
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
        this.rentedVehicles = new HashMap<>();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Map<T, Integer> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(Map<T, Integer> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void addVehicleToRental(T vehicle, int days) {
        if (rentedVehicles.containsKey(vehicle)) {
            rentedVehicles.put(vehicle, rentedVehicles.get(vehicle) +
                    days);
        } else {
            rentedVehicles.put(vehicle, days);
        }
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (T vehicle : rentedVehicles.keySet()) {
            double duration = rentedVehicles.getOrDefault(vehicle, 0);
            totalAmount += duration * vehicle.getRentalRate();
        }
        return totalAmount;
    }
}

class CustomerV2 {
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<RentalTransaction<? extends Vehicle>> rentalHistory;

    public CustomerV2(String customerId, String name, String
            phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<RentalTransaction<? extends Vehicle>>
    getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<RentalTransaction<? extends
            Vehicle>> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public void addRentalTransaction(RentalTransaction<? extends
            Vehicle> transaction) {
        rentalHistory.add(transaction);
    }
}

class RentalCompany {
    private String companyName;
    private List<CustomerV2> customers;
    private Map<String, Vehicle> vehicleInventory;

    public RentalCompany(String companyName) {
        this.companyName = companyName;
        this.customers = new ArrayList<>();
        this.vehicleInventory = new HashMap<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<CustomerV2> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerV2> customers) {
        this.customers = customers;
    }

    public Map<String, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(Map<String, Vehicle>
                                            vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public void addCustomer(CustomerV2 customer) {
        customers.add(customer);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleInventory.put(vehicle.getVehicleId(), vehicle);
    }

    public CustomerV2 getCustomer(String customerId) {
        for (CustomerV2 customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayInventory() {
        for (String vehicle : vehicleInventory.keySet()) {
            System.out.println(vehicleInventory.get(vehicle).getDescription());
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (CustomerV2 customer : customers) {
            for (RentalTransaction<? extends Vehicle> transaction :
                    customer.getRentalHistory()) {
                totalRevenue += transaction.calculateTotalAmount();
            }
        }
        return totalRevenue;
    }
}

class MainProgram {
    public static void main(String[] args) {
        RentalCompany company = new RentalCompany("Advanced Rentals");
        Car car = new Car("C001", "Toyota Corolla", 50, CarType.SEDAN,
                "Petrol");
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R3",
                30, 321);
        company.addVehicle(car);
        company.addVehicle(motorcycle);
        CustomerV2 customer = new CustomerV2("CU001", "Alice Smith",
                "123-456-7890");
        RentalTransaction<Car> carRental = new
                RentalTransaction<>("T001", new Date(), 1);
        carRental.addVehicleToRental(car, 3);
        RentalTransaction<Motorcycle> motorcycleRental = new
                RentalTransaction<>("T002", new Date(), 1);
        motorcycleRental.addVehicleToRental(motorcycle, 5);
        customer.addRentalTransaction(carRental);
        customer.addRentalTransaction(motorcycleRental);
        company.addCustomer(customer);
        company.displayInventory();
        System.out.println("Total Revenue: $" +
                company.calculateTotalRevenue());
    }
}