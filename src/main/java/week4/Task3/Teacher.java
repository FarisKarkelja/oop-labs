package week4.Task3;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int age, String country, int salary) {
        super(name, address, age, country);
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
        return super.getName() + "\n" + "  " + super.getAddress() + "\n" + "  salary " + this.salary + " euros/month" + "\n" + " " + super.getAge() + "\n" + " " + super.getCountry();
    }
}
