package com.student.management.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.student.management.model.Student;
import com.student.management.DBConnection;

public class StudentDAO {

    // ✅ Add a new student to the database
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, email, phone, course) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPhone());
            stmt.setString(5, student.getCourse());
            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Retrieve all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // ✅ Update student details
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET first_name=?, last_name=?, email=?, phone=?, course=? WHERE student_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPhone());
            stmt.setString(5, student.getCourse());
            stmt.setInt(6, student.getStudentId());
            stmt.executeUpdate();
            System.out.println("✅ Student updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete student by ID
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.executeUpdate();
            System.out.println("🗑️ Student deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
