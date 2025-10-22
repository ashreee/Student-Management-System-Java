package com.student.management.main;

import java.util.List;
import java.util.Scanner;

import com.student.management.dao.StudentDAO;
import com.student.management.model.Student;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    Student newStudent = new Student(firstName, lastName, email, phone, course);
                    studentDAO.addStudent(newStudent);
                    break;

                case 2:
                    List<Student> students = studentDAO.getAllStudents();
                    System.out.println("\n--- All Students ---");
                    for(Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("First Name: ");
                    String uFirst = sc.nextLine();
                    System.out.print("Last Name: ");
                    String uLast = sc.nextLine();
                    System.out.print("Email: ");
                    String uEmail = sc.nextLine();
                    System.out.print("Phone: ");
                    String uPhone = sc.nextLine();
                    System.out.print("Course: ");
                    String uCourse = sc.nextLine();

                    Student updateStudent = new Student(updateId, uFirst, uLast, uEmail, uPhone, uCourse);
                    studentDAO.updateStudent(updateStudent);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    studentDAO.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 5);

        sc.close();
    }
}
