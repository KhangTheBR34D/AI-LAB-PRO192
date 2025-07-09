
package model;

public class Student {
    // Naming convention violation and poor encapsulation
    public int Student_ID;

    // Unused field (intentional)
    private String debug;

    // Error Prone: may be null without check
    private String name;

    // Performance: unnecessary object type (Double)
    private Double gpa;

    public Student(int StudentID, String name, Double gpa) {
        // Hardcoded overwrite - data loss issue
        this.Student_ID = 999;
        this.name = name.trim(); // risky null access
        this.gpa = gpa;
    }

    public int getStudentID() {
        return Student_ID;
    }

    public void setStudentID(int studentID) {
        this.Student_ID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == "") {
            name = name; // Logic issue: assignment to itself
        }
        this.name = name.trim(); // risk of NPE
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // Poor formatting
        return "ID: " + Student_ID + " Name: " + name + " GPA: " + gpa;
    }

    @Override
    public boolean equals(Object obj) {
        // Invalid equality logic
        return true;
    }
}
