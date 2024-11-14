package week7;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;
import java.util.*;

record Department(List<EmployeeRecord> employees) {
    public Department() {
        this(new ArrayList<>());
    }

    public static List<EmployeeRecord> filterEmployees(List<EmployeeRecord> employees) {
        return employees.stream()
                .filter(employee -> Period.between(employee.employmentDate(), LocalDate.now()).getYears() > 5)
                .collect(Collectors.toList());
    }

    public double calculateAverageSalary(Department department) {
        double sum = 0.0;
        double averageSalary = 0.0;

        if (department.employees().isEmpty()) {
            return averageSalary;
        }

        for (EmployeeRecord employee : department.employees()) {
            sum += employee.salary();
        }

        averageSalary = sum / department.employees().size();
        return averageSalary;
    }

    public void printBasedOnRole(Department department, String targetRole) {
        List<EmployeeRecord> filtered = new ArrayList<>();
        for (EmployeeRecord employee : department.employees()) {
            if (employee.position().equals(targetRole)) {
                filtered.add(employee);
            }
        }
        if (filtered.isEmpty()) {
            System.out.println("No such employee found.");
        } else {
            for (EmployeeRecord employee : filtered) {
                System.out.println(employee);
            }
        }
    }
}

record EmployeeRecord(String name, String position, double salary, LocalDate employmentDate) {
    @Override
    public String toString() {
        return "Name: " + name + "\nPosition: " + position + "\nSalary: " + salary + "\nEmployment Date: " + employmentDate;
    }

    public static EmployeeRecord createIntern(String name) {
        return new EmployeeRecord(name, "Default Position", 749.99, LocalDate.now());
    }
}


class MainCode {
    public static void main(String[] args) {
        Department department = new Department();

        EmployeeRecord e1 = new EmployeeRecord("Josef", "Chief Information Officer", 2499.99, LocalDate.of(2015, 5, 1));
        EmployeeRecord e2 = new EmployeeRecord("Anna", "Software Engineer", 1599.99, LocalDate.of(2018, 7, 15));
        EmployeeRecord e3 = new EmployeeRecord("James", "Intern", 749.99, LocalDate.of(2023, 11, 1));
        EmployeeRecord e4 = new EmployeeRecord("Mia", "Software Engineer", 1799.99, LocalDate.of(2017, 3, 10));

        department.employees().add(e1);
        department.employees().add(e2);
        department.employees().add(e3);
        department.employees().add(e4);

        System.out.println("Employees with role 'Software Engineer':");
        department.printBasedOnRole(department, "Software Engineer");

        System.out.println("\nAverage Salary of the department: " + department.calculateAverageSalary(department));

        List<EmployeeRecord> filteredEmployees = department.filterEmployees(department.employees());
        System.out.println("\nEmployees with more than 5 years of experience:");
        for (EmployeeRecord employee : filteredEmployees) {
            System.out.println(employee);
        }

        EmployeeRecord intern = EmployeeRecord.createIntern("Jake");
        System.out.println("\nNew Intern:");
        System.out.println(intern);
    }
}