package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null");

        for (Student s : students) {
            if (s.getStudentID() == student.getStudentID()) {
                throw new IllegalArgumentException("Duplicate student ID: " + student.getStudentID());
            }
        }

        if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        students.add(student);
        return true;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentID() == id);
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> results = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) return results;

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Defensive copy
    }
}