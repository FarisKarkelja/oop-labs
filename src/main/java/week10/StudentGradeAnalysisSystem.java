package week10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class StudentGradeAnalysisSystem {

}

class Student {
    private String name;
    private int ID;
    private List<Integer> grades;

    public Student(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String printInfo() {
        return "Name: " + name + ", ID: " + ID + ", Grades: " + grades;
    }
}

class GradeAnalyzer {
    private List<Integer> grades;

    public GradeAnalyzer() {
        this.grades = new ArrayList<>();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        double sum = 0.0;
        double average;
        for (int grade : grades) {
            sum += grade;
        }
        average = sum / grades.size();
        return average;
    }

    public String printSummary() {
        return "Grades: " + grades + "\nAverage: " + calculateAverage();
    }
}

class Start {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        List<Integer> grades = new ArrayList<>();
        Collections.addAll(grades, 4, 5, 5, 1, 1, 2, 3, 5, 5, 5);

        Student student = new Student("John", 23);
        student.setGrades(grades);

        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer();
        gradeAnalyzer.setGrades(grades);

        Field[] studentFields = student.getClass().getDeclaredFields();
        Field[] analyzerFields = gradeAnalyzer.getClass().getDeclaredFields();

        for (Field f : studentFields) {
            f.setAccessible(true);
            System.out.println(f.getName());
            System.out.println(f.get(student));
        }

        for (Field f : analyzerFields) {
            f.setAccessible(true);
            System.out.println(f.getName());
            System.out.println(f.get(gradeAnalyzer));
        }

        Method[] studentMethods = student.getClass().getDeclaredMethods();
        Method[] analyzerMethods = gradeAnalyzer.getClass().getDeclaredMethods();

        for(Method m : studentMethods) {
            if(m.getName().startsWith("calculate") || m.getName().startsWith("print")){
                m.setAccessible(true);
                if(m.getReturnType() != void.class){
                    m.invoke(student);
                    System.out.println(m.invoke(student));
                } else {
                    System.out.println("Void type method invoked.");
                }
            }
        }

        for(Method m : analyzerMethods) {
            if(m.getName().startsWith("calculate") || m.getName().startsWith("print")){
                m.setAccessible(true);
                if(m.getReturnType() != void.class){
                    System.out.println(m.invoke(gradeAnalyzer));
                } else {
                    m.invoke(gradeAnalyzer);
                    System.out.println("Void type method invoked.");
                }
            }
        }
    }
}