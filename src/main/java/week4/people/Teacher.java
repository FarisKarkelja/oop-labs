package week4.people;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.getName() + "\n" + "  " + super.getAddress() + "\n" + "  salary " + this.salary + " euros/month";
    }
}
