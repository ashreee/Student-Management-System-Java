
# 📝 Student Management System – Project Showcase

## **Project Overview**

The **Student Management System** is a console-based Java application that allows you to manage student records with **full CRUD operations**.
It uses **Java, JDBC, and MySQL** for database management.

**Key Features:**

* Add new students
* View all students
* Update student details
* Delete students
* Interactive console menu

---

## **Technologies Used**

| Technology   | Purpose                   |
| ------------ | ------------------------- |
| Java 19      | Core programming language |
| JDBC         | Database connectivity     |
| MySQL 8      | Data storage              |
| Eclipse IDE  | Development environment   |
| Git & GitHub | Version control           |

---

## **Project Structure**

```
StudentManagementSystem/
 ├─ src/
 │   └─ com.student.management/
 │       ├─ DBConnection.java
 │       ├─ dao/
 │       │   └─ StudentDAO.java
 │       ├─ model/
 │       │   └─ Student.java
 │       └─ main/
 │           └─ MainApp.java
 ├─ lib/
 │   └─ mysql-connector-j-9.5.0.jar
 ├─ .gitignore
 └─ README.md
```

---

## **Setup Instructions**

1. **Clone the Repository**

```bash
git clone https://github.com/ashreee/Student-Management-System-Java.git
cd Student-Management-System-Java
```

2. **Configure Database**

* Open MySQL Workbench or command line
* Create database:

```sql
CREATE DATABASE StudentDB;
USE StudentDB;
```

* Create `students` table:

```sql
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    course VARCHAR(100)
);
```

3. **Update DBConnection.java**

```java
private static final String USER = "root";   // Your MySQL username
private static final String PASSWORD = "yourpassword"; // Your MySQL password
```

4. **Add MySQL JDBC Driver**

* Place `mysql-connector-j-9.5.0.jar` in `lib/`
* Add to Build Path in Eclipse

5. **Run the Application**

* Run `MainApp.java`
* Use menu to Add, View, Update, Delete students

---

## **Sample Console Output**

**Add Student:**

```
=== Student Management System ===
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 1
First Name: Ziva
Last Name: Ezlin
Email: ziva2@gmail.com
Phone: 8987787667
Course: BE
✅ Database connected successfully!
✅ Student added successfully!
📄 Added Student Details:
Student [studentId=1, firstName=Ziva, lastName=Ezlin, email=ziva2@gmail.com, phone=8987787667, course=BE]
```

**View All Students:**

```
--- All Students ---
Student [studentId=1, firstName=Ziva, lastName=Ezlin, email=ziva2@gmail.com, phone=8987787667, course=BE]
```

**Update Student:**

```
Enter Student ID to update: 1
First Name: Ziva
Last Name: Ezlin
Email: ziva_updated@gmail.com
Phone: 9876543210
Course: BE
✅ Student updated successfully!
📄 Updated Student Details:
Student [studentId=1, firstName=Ziva, lastName=Ezlin, email=ziva_updated@gmail.com, phone=9876543210, course=BE]
```

**Delete Student:**

```
Enter Student ID to delete: 1
🗑️ Student deleted successfully!
📄 Deleted Student Details:
Student [studentId=1, firstName=Ziva, lastName=Ezlin, email=ziva_updated@gmail.com, phone=9876543210, course=BE]

