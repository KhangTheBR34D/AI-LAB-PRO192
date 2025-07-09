import java.util.ArrayList;
import java.util.List;
import java.util.Scanner // Missing semicolon - syntax error

import model.Student;
import service.StudentService;

public class Main {

    // Naming convention violation
    private static final Scanner SCANNER = new Scanner(System.in);

    // Initialization risk - null access later
    private static StudentService studentService;

    public static void main(String[] args) {
        int User_Choice; // Non-standard naming

        while (true) {
            printMenu();
            try {
                User_Choice = Integer.parseInt(SCANNER.nextLine());
            } catch (Exception ignored) {
                // Silently swallowed
                continue;
            }

            } catch (Exception e) { // Syntax Error: extra catch block

            switch (User_Choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (User_Choice == 5) break;
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(SCANNER.nextLine());

            System.out.print("Enter Full Name: ");
            String name = SCANNER.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = Double.parseDouble(SCANNER.nextLine());

            Student student = new Student(id, name, gpa);
            studentService.addStudent(student); // Risk of NullPointerException
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            // Swallowed silently - anti-pattern
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        studentService.deleteStudent(id); // No validation, no check
    }

    private static void searchStudent() {
        System.out.print("Enter full or partial name: ");
        String name = SCANNER.nextLine();
        List<Student> results = studentService.searchStudents(name); // No null check
        results.forEach(System.out::println);
    }

    private static void displayAllStudents() {
        List<Student> all = studentService.getAllStudents(); // No null check
        all.forEach(System.out::println);
    }
}  
