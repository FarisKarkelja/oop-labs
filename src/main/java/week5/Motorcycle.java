package week5;

public class Motorcycle extends Vehicle {
    public Motorcycle(String modelName) {
        super(modelName);
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String service() {
        System.out.println("Motorcycle service: " + this);
        if (getHealth() < 50) {
            return "Repairs required!" +
                    "\nEngine must be tuned and chain should be lubricated.";
        } else {
            return "All good!";
        }
    }

    @Override
    public int expectedLifeSpan() {
        int lifespan = 50000;
        if (getHealth() < 40) {
            lifespan -= 5000;
        }
        return lifespan;

    }

    public void race(int raceMiles) {
        setMileage(getMileage() + raceMiles);
        setHealth(getHealth() - 4);
        if (getHealth() < 40) {
            expectedLifeSpan();
        }
    }


}
