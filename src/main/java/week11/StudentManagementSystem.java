package week11;

import java.util.*;
import java.io.*;

class Student {
    private int ID;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(int ID, String name, String university, String department, double GPA) {
        this.ID = ID;
        this.name = name;
        this.university = university;
        this.department = department;
        this.GPA = GPA;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return name;
    }
}

class InvalidStudentDataException extends Exception {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class StudentSystem {
    private List<Student> students;

    public StudentSystem(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            students = new ArrayList<>();
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] data = temp.split(",");
                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                String university = data[2];
                String department = data[3];
                double GPA = Double.parseDouble(data[4]);
                students.add(new Student(ID, name, university, department, GPA));
            }
            validateStudentData(students);
        } catch (IOException | InvalidStudentDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public StudentSystem(List<Student> students) {
        this.students = students;
    }

    public static List<Student> readStudents(String filename) {
        List<Student> generatedStudents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] data = temp.split(",");
                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                String university = data[2];
                String department = data[3];
                double GPA = Double.parseDouble(data[4]);
                generatedStudents.add(new Student(ID, name, university, department, GPA));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return generatedStudents;
    }

    public int noOfStudent() {
        return students.size();
    }

    public Optional<Student> getStudentByID(int ID) {
        for (Student student : students) {
            if (student.getID() == ID) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Student getHighestGPA() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student studentWithHighestGPA = students.get(0);
        for (Student student : students) {
            if (student.getGPA() > studentWithHighestGPA.getGPA()) {
                studentWithHighestGPA = student;
            }
        }
        return studentWithHighestGPA;
    }

    public Student getLongestNameStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student studentWithLongestName = students.get(0);
        for (Student student : students) {
            if (student.getName().length() > studentWithLongestName.getName().length()) {
                studentWithLongestName = student;
            }
        }
        return studentWithLongestName;
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException {
        for (Student student : students) {
            if (student.getGPA() < 6 || student.getGPA() > 10) {
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }
}

class StudentManagementSystem {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Korisnik\\OneDrive\\Desktop\\students.csv";
        StudentSystem system = new StudentSystem(filename);

        System.out.println("Number of students: " + system.noOfStudent());

        System.out.println(StudentSystem.readStudents(filename));

        Optional<Student> student = system.getStudentByID(55);
        student.ifPresent(s -> System.out.println("Student found: " + s));

        try {
            Student topStudent = system.getHighestGPA();
            System.out.println("Student with highest GPA: " + topStudent);
        } catch (EmptyStudentListException e) {
            System.out.println(e.getMessage());
        }

        try {
            Student longestNameStudent = system.getLongestNameStudent();
            System.out.println("Student with the longest name: " + longestNameStudent);
        } catch (EmptyStudentListException e) {
            System.out.println(e.getMessage());
        }
    }
}