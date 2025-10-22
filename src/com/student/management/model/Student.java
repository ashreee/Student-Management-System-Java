package com.student.management.model;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String course;

    // Constructor
    public Student(int studentId, String firstName, String lastName, String email, String phone, String course) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.course = course;
    }

    // Overloaded constructor (for inserts where ID is auto-generated)
    public Student(String firstName, String lastName, String email, String phone, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.course = course;
    }

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + firstName + " " + lastName +
               ", Email=" + email + ", Phone=" + phone + ", Course=" + course + "]";
    }
}
