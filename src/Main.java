import model.Student;
import service.StudentService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                choice = 0;
            }
        } while (choice != 5);
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
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            Student student = new Student(id, name, gpa);
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean deleted = studentService.deleteStudent(id);
            if (deleted) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID input.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter full or partial name: ");
        String keyword = scanner.nextLine();
        List<Student> results = studentService.searchStudents(keyword);
        if (results.isEmpty()) {
            System.out.println("No students matched your search.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void displayAllStudents() {
        List<Student> all = studentService.getAllStudents();
        if (all.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.printf("%-10s %-30s %-5s\n", "ID", "Name", "GPA");
            all.forEach(System.out::println);
        }
    }
}