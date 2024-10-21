package week4.Task3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 48, "Finland", 1200));
        people.add(new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki", 63, "Finland"));
        printDepartment(people);
    }

    public static void printDepartment(List<Person> people) {
        System.out.println(people);
    }

}
