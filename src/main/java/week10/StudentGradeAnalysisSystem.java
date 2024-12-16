package week10;

import java.lang.reflect.*;
import java.util.*;
import java.lang.*;

class Student {
    private String name;
    private int ID;
    private List<Integer> grades;

    public Student(String name, int ID, Integer[] grades) {
        this.name = name;
        this.ID = ID;
        this.grades = Arrays.asList(grades);
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
}

class GradeAnalyzer {
    List<Integer> grades;

    public GradeAnalyzer(Integer[] grades) {
        this.grades = Arrays.asList(grades);
    }

    public double calculateAverage() {
        double sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void printSummary() {
        System.out.println("Average grade is " + calculateAverage());
    }
}

class MainCall {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Student student = new Student("Safet", 32, new Integer[]{4, 3, 2, 5, 5, 5, 5});
        GradeAnalyzer analyzer = new GradeAnalyzer(new Integer[]{4, 3, 2, 5, 5, 5, 5});

        Field[] studentFields = student.getClass().getDeclaredFields();
        for (Field field : studentFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " : " + field.get(student));
        }

        Field[] analyzerFields = analyzer.getClass().getDeclaredFields();
        for (Field field : analyzerFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " : " + field.get(analyzer));
        }

        Method[] studentMethods = student.getClass().getDeclaredMethods();
        for (Method method : studentMethods) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                method.setAccessible(true);
                if (method.getReturnType().equals(void.class)) {
                    System.out.println("Void method was invoked.");
                    method.invoke(student);
                } else {
                    System.out.println("Non-void method was invoked.");
                    method.invoke(student);
                }
            }
        }

        Method[] analyzerMethods = analyzer.getClass().getDeclaredMethods();
        for (Method method : analyzerMethods) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                method.setAccessible(true);
                if (method.getReturnType().equals(void.class)) {
                    System.out.println("Void method was invoked.");
                    method.invoke(analyzer);
                } else {
                    System.out.println("Non-void method was invoked.");
                    method.invoke(analyzer);
                }
            }
        }
    }
}

