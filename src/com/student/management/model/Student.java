package com.student.management.model;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String course;

    // Constructor without ID (for adding)
    public Student(String firstName, String lastName, String email, String phone, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.course = course;
    }

    // Constructor with ID (for update)
    public Student(int studentId, String firstName, String lastName, String email, String phone, String course) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.course = course;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", phone=" + phone + ", course=" + course + "]";
    }
}
