package week5;

public class Truck  extends Vehicle implements Repairable {
    public Truck(String modelName) {
        super(modelName);
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        System.out.println("Truck service: " + this);
        if (getHealth() < 50) {
            return "Repairs required!";
        } else {
            return "All good!";
        }
    }

    @Override
    public int expectedLifeSpan() {
        int lifespan = 300000;
        if (getHealth() < 30) {
            lifespan -= 20000;
        }
        return lifespan;
    }

    public void haul(int loadWeight){
        if(loadWeight > 5000){
            setHealth(getHealth() - 5);
        } else {
            setHealth(getHealth() - 2);
        }
        if (getHealth() < 30) {
            expectedLifeSpan();
        }
    }

}
