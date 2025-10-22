package com.student.management.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.student.management.DBConnection;
import com.student.management.model.Student;

public class StudentDAO {

    // Add student
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, email, phone, course) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getCourse());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    student.setStudentId(id);
                    System.out.println("✅ Student added successfully!");
                    System.out.println("📄 Added Student Details:");
                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("course")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Get student by ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("course")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update student
    public void updateStudent(Student student) {
        Student existing = getStudentById(student.getStudentId());
        if (existing == null) {
            System.out.println("❌ Student ID " + student.getStudentId() + " not found!");
            return;
        }

        String sql = "UPDATE students SET first_name=?, last_name=?, email=?, phone=?, course=? WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getCourse());
            ps.setInt(6, student.getStudentId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Student updated successfully!");
                System.out.println("📄 Updated Student Details:");
                System.out.println(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int studentId) {
        Student existing = getStudentById(studentId);
        if (existing == null) {
            System.out.println("❌ Student ID " + studentId + " not found!");
            return;
        }

        String sql = "DELETE FROM students WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("🗑️ Student deleted successfully!");
                System.out.println("📄 Deleted Student Details:");
                System.out.println(existing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
