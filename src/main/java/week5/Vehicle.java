package week5;

public abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public int getHealth() {
        return health;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract String service();

    public abstract int expectedLifeSpan();

    public boolean needsMaintenance() {
        return this.health < 70;
    }

    public int calculateRemainingLifespan() {
        int expectedLifespan = expectedLifeSpan();
        double healthFactor;
        if (this.health < 50) {
            healthFactor = this.health / 100.0;
        } else {
            healthFactor = 1.0;
        }
        int adjustedLifespan = (int) (expectedLifespan * healthFactor);
        return Math.max(0, adjustedLifespan - this.mileage);
    }

    public void simulateYear() {
        if (mileage >= expectedLifeSpan() / 2) {
            setHealth(this.health - 5);
        }
    }

    public void performMaintenance(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car localCar = (Car) vehicle;
            localCar.repair();
            localCar.drive(145);
        } else if (vehicle instanceof Truck) {
            Truck localTruck = (Truck) vehicle;
            localTruck.repair();
            localTruck.haul(2200);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle localMotorcycle = (Motorcycle) vehicle;
            localMotorcycle.race(45);
        } else {
            System.out.println("Unknown vehicle type. No maintenance performed.");
        }
    }

    @Override
    public String toString() {
        return "Model: " + this.modelName +
                "\nMileage: " + this.mileage +
                "\nHealth: " + this.health;
    }
}
