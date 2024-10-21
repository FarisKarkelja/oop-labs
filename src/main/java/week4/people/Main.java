package week4.people;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Task 1, subtask a
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);

        //Task 1, subtask b
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.getCredits());
        olli.study();
        System.out.println("credits " + olli.getCredits());

        //Task 1, subtask c
        Teacher pekka2 = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko2 = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println(pekka2);
        System.out.println(esko2);

        Student olli2 = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for (int i = 0; i < 25; i++) {
            olli2.study();
        }
        System.out.println(olli2);

        //Task 1, subtask d
        List<Person> people = new ArrayList<>();
        people.add(new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200));
        people.add(new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki"));
        printDepartment(people);
    }

    public static void printDepartment(List<Person> people) {
        System.out.println(people);
    }

}
