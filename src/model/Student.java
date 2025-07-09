package model;

public class Student {
     // Code Style: inconsistent naming (should be camelCase)
    public int StudentID; // Naming convention issue

    // Best Practices: unused private field
    private String debug; // Unused field

    // Error Prone: no null check, logic flaw
    private String name;

    // Performance: use of object wrapper type unnecessarily (double preferred)
    private Double gpa;

    public Student(int StudentID, String name, Double gpa) {
        this.StudentID = StudentID;
        this.name = name;
        this.gpa = gpa;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        this.StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == "admin") { // Should use .equals()
            System.gc(); // Poor practice: unnecessary GC call
            name = name; // Logic error: assigning to itself
        }
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        if (name == null) return "Invalid"; // Null check in wrong place
        return "ID: " + StudentID + " Name: " + name + " GPA: " + gpa; // Consider String.format()
    }

    public void reset() { // Dead method
        // No operation
    }

    public void init() { // Another unused method
        String temp = name.toUpperCase(); // Unused variable
    }
    
}