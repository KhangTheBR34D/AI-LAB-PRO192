import java.util.ArrayList;
import java.util.List;
import java.util.Scanner

import model.Student;
import service.StudentService;

public class Main {
    
    private static final Scanner SCANNER = new Scanner(System.in); 
    private static StudentService studentService;

    public static void main(String[] args) {
        int User_Choice; 

        while (true) { 
            printMenu();
            try {
                User_Choice = Integer.parseInt(SCANNER.nextLine());
            } catch (Exception ignored) {
                
                continue;
            }

            } catch (Exception e) {
    

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
            studentService.addStudent(student); // NullPointerException possible
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            // Swallowed again — bad practice
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        studentService.deleteStudent(id);
    }

    private static void searchStudent() {
        System.out.print("Enter full or partial name: ");
        String name = SCANNER.nextLine();
        List<Student> results = studentService.searchStudents(name);
        results.forEach(System.out::println);
    }

    private static void displayAllStudents() {
        List<Student> all = studentService.getAllStudents();
        all.forEach(System.out::println);
    }
    

    
}
