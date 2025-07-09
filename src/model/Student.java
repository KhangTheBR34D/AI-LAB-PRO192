
package model;

public class Student {
    private int studentId;
    private String name;
    private double gpa;

    public Student(int studentId, String name, double gpa) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID must be positive.");
        }
        if (name == null || name.trim().isEmpty() || name.length() > 50) {
            throw new IllegalArgumentException("Name must be non-empty and max 50 characters.");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.studentId = studentId;
        this.name = name.trim();
        this.gpa = gpa;
    }

    public int getStudentID() {
        return studentId;
    }

    public void setStudentID(int studentID) {
        if (studentID < 0) {
            throw new IllegalArgumentException("Student ID must be positive.");
        }
        this.studentId = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty() && name.length() <= 50) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Invalid name. Must be non-empty and <= 50 characters.");
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-50s %.2f", studentId, name, gpa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return studentId == other.studentId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(studentId);
    }
} 

