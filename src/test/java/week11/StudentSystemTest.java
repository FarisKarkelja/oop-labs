package week11;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;

class StudentSystemTest {

    StudentSystem system;
    String filename = "C:\\Users\\Korisnik\\OneDrive\\Desktop\\students.csv";

    @BeforeEach
    void setup() {
        system = new StudentSystem(filename);
    }

    @Test
    void testIfStudentIsPresent() {
        assertTrue(system.noOfStudent() > 0, "There should be at least one student in the system.");
    }

    @Test
    void testStudentWithId100() {
        Optional<Student> student = system.getStudentByID(100);
        assertTrue(student.isEmpty(), "There should not exist a student with ID 100.");
    }

    @Test
    void testHighestGPAStudent() {
        Student topStudent = system.getHighestGPA();
        assertEquals(9.8, topStudent.getGPA(), "Student with highest GPA should have a GPA of 9.8.");
    }

    @Test
    void testExceptionForEmptyStudentList() {
        RuntimeException exception = assertThrows(EmptyStudentListException.class, () -> {
            StudentSystem emptyFile = new StudentSystem("C:\\Users\\Korisnik\\OneDrive\\Desktop\\empty.txt");
            emptyFile.getHighestGPA();
        });
    }

    @Test
    void testExceptionMessageForEmptyStudentList() {
        RuntimeException exception = assertThrows(EmptyStudentListException.class, () -> {
            StudentSystem emptyFile = new StudentSystem("C:\\Users\\Korisnik\\OneDrive\\Desktop\\empty.txt");
            emptyFile.getHighestGPA();
        });
        assertEquals("List of students is empty.", exception.getMessage(), "The messages should match.");
    }

    @Test
    void testNamesArray() {
        List<Student> students = StudentSystem.readStudents(filename);
        String[] expected = {
                "Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson"
        };
        String[] actual = students.stream()
                .map(Student::getName)
                .limit(5)
                .toArray(String[]::new);
        assertArrayEquals(expected, actual, "The first five student names should match the expected names.");
    }

    @Test
    void testSameStudent() {
        Student student = system.getHighestGPA();
        Optional<Student> stu = system.getStudentByID(12);
        assertTrue(stu.isPresent(), "Student with ID 12 should be present.");
        assertSame(student, stu.get(), "Student with the highest GPA should be the same as the student with ID 12.");
    }

    @Test
    void testReadStudents() {
        List<Student> students = StudentSystem.readStudents(filename);
        assertFalse(students.isEmpty(), "The read students list should not be empty.");
    }

    @Test
    void testNoOfStudent() {
        assertEquals(70, system.noOfStudent(), "The number of students should match the expected value.");
    }

    @Test
    void testToStringMethod() {
        Student student = system.getStudentByID(15).orElseThrow();
        assertEquals("Joseph Diaz", student.toString(), "The toString method should return the student's name.");
    }

    @Test
    void testGetName() {
        Student student = system.getStudentByID(45).orElseThrow();
        assertEquals("David Rodriguez", student.getName(), "The student's name should match.");
    }

    @Test
    void testGetUniversity() {
        Student student = system.getStudentByID(5).orElseThrow();
        assertEquals("Stanford University", student.getUniversity().replace("\"", ""), "The student's university should match.");
    }

    @Test
    void testGetDepartment() {
        Student student = system.getStudentByID(3).orElseThrow();
        assertEquals("Finance", student.getDepartment(), "The student's department should match.");
    }

    @Test
    void testGetLongestNameStudent() {
        Student longestNameStudent = system.getLongestNameStudent();
        assertNotNull(longestNameStudent, "The student with the longest name should not be null.");

        int maxLength = longestNameStudent.getName().length();
        for (Student student : StudentSystem.readStudents(filename)) {
            assertTrue(student.getName().length() <= maxLength, "No student should have a longer name than the one identified.");
        }
    }

    @Test
    void testValidStudentData() {
        List<Student> validStudents = Arrays.asList(
                new Student(1, "John Doe", "University A", "Computer Science", 8.5),
                new Student(2, "Jane Smith", "University B", "Mathematics", 9.2)
        );

        StudentSystem system = new StudentSystem(validStudents);

        try {
            Method validateMethod = StudentSystem.class.getDeclaredMethod("validateStudentData", List.class);
            validateMethod.setAccessible(true);
            validateMethod.invoke(system, validStudents);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}