package week4.Task4;

import java.util.ArrayList;

public class Student extends Person {
    private int credits = 0;
    private int studentId;
    private ArrayList<Character> studentGrades;

    public Student(String name, String address, int age, String country) {
        super(name, address, age, country);
        this.studentGrades = new ArrayList<>();
    }

    public Student(String name, String address, int age, String country, int credits, int studentId, ArrayList<Character> studentGrades) {
        super(name, address, age, country);
        this.credits = credits;
        this.studentId = studentId;
        this.studentGrades = studentGrades;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void study() {
        this.credits++;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Character> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(ArrayList<Character> studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String toString() {
        return super.getName() + "\n" + "  " + super.getAddress() + "\n" + "  credits " + this.credits + "\n" + "  " + super.getAge() + "\n" + "  " + super.getCountry() + "\n" + "  " + this.studentId + "\n" + "  " + this.studentGrades;
    }

    public void addGrade(char grade) {
        char[] possibleGrades = {'A', 'B', 'C', 'D', 'E', 'F'};
        boolean isValid = false;

        for (char g : possibleGrades) {
            if (g == grade) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            studentGrades.add(grade);
        } else {
            System.out.println("Invalid grade! Please try again.");
        }
    }
}
