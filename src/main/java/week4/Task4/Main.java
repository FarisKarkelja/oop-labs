package week4.Task4;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> grades = new ArrayList<>();
        Collections.addAll(grades, 'A', 'A', 'B', 'E', 'F', 'A');
        Student student = new Student("Student", "Address 1", 21, "Spain", 60, 3, grades);
        student.addGrade('B');
        System.out.println(student);

        Teacher teacher = new Teacher("Simon", "Street 32", 46, "Argentina", 3200);
        System.out.println(teacher);
    }
}
