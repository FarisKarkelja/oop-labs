package week5;

public class Car extends Vehicle implements Repairable {

    public Car(String modelName) {
        super(modelName);
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine tuned and oil changed for " + getModelName();
    }

    @Override
    public String service() {
        System.out.println("Car service: " + this);
        if (getHealth() < 50) {
            return "Repairs required!";
        } else {
            return "All good!";
        }
    }

    @Override
    public int expectedLifeSpan() {
        int lifespan = 150000;
        if (getHealth() < 30) {
            lifespan -= 10000;
        }
        return lifespan;
    }

    public void drive(int miles) {
        setMileage(getMileage() + miles);
        setHealth(getHealth() - 1);
        if (getHealth() < 30) {
            expectedLifeSpan();
        }
    }

}
