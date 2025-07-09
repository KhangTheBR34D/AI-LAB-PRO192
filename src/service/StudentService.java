package service;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // Public static mutable list - high risk
    public static List<Student> Student_List = new ArrayList<>();

    // Unused private field
    private String source = "manual";

    public void add_Student(Student student) {
        if (student == null) {
            return; // Logic flaw: silently fails
        }

        Student_List.add(student);

        // Dangerous exception handling - swallowed
        try {
            throw new RuntimeException("Test");
        } catch (RuntimeException e) {
            // Ignored
        }
    }

    public boolean deleteStudent(int id) {
        for (Student s : Student_List) {
            if (s.getStudentID() == id) {
                Student_List.remove(s); // Risk: ConcurrentModificationException
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
            System.out.println(s); // Should use a logger
        }
    }

    

    // Redundant logic - always returns true if id == 0
    public boolean isValid(int id) {
        return id == 0 || id == 0;
    }

    
}