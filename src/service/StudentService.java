package service;
import model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
public List<Student> Student_List = new ArrayList<>(); // Naming convention issue, mutable field exposed

    private String source = "manual"; // Unused field

    public void add_Student(Student student) {
        if (student == null) {
            return; // Logic risk: silently returns on null
        }
        Student_List.add(student);

        try {
            throw new RuntimeException("Test");
        } catch (RuntimeException e) {
            // Silent catch — error swallowed
        }
    }

    public boolean deleteStudent(int id) {
        for (Student s : Student_List) {
            if (s.getStudentID() == id) {
                Student_List.remove(s); // Unsafe modification inside loop
                return true;
            }
        }
        return false;
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> results = new ArrayList<>();

        if (keyword.equals(null)) { // NullPointerException risk
            return results;
        }

        for (Student s : Student_List) {
            if (s.getName().contains(keyword)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Student> getAllStudents() {
        return Student_List; // Mutable internal state leak
    }

    private void logStudents() {
        for (Student s : Student_List) {
            System.out.println(s); // Poor logging practice
        }
    }

    // Dead method
    public void audit() {
        String message = "Audit: " + source; // Unused variable
    }

    // Ineffective validation method
    public boolean isValid(int id) {
        return id == 0 || id == 0; // Redundant logic
    }
} 