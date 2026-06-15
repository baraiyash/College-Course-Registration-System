# 🎓 College Course Registration System

A Core Java console-based application that simulates a college course registration system. The project demonstrates Object-Oriented Programming (OOP) principles and Core Java concepts including Inheritance, Polymorphism, Collections Framework, and Exception Handling.

This project was developed as an MCA Core Java Termwork.

---

## 🚀 Features

### 👨‍🎓 Student Module

* Student Login using Student ID
* View Available Courses
* Search Course by Name
* Register for a Course
* Drop Registered Courses
* View Registered Courses
* View Student Profile Summary
* Maximum Course Registration Limit Validation

### 👨‍💼 Admin Module

* Add New Student
* View All Students
* Add New Course
* Remove Existing Course
* View Available Courses

---

## 🧩 Java Concepts Implemented

### Inheritance

```text
Person
├── Student
└── Admin
```

Student and Admin classes inherit common properties from the Person class.

### Polymorphism

```java
Person p1 = currentStudent;
p1.dashboard();

Person p2 = admin;
p2.dashboard();
```

Method overriding is used to provide different dashboard implementations for Student and Admin.

### Collections Framework

The project uses:

```java
ArrayList<Course>
HashMap<Integer, Student>
Iterator<Course>
```

* ArrayList for course storage
* HashMap for student management
* Iterator for safe removal operations

### Exception Handling

Custom Exceptions:

```java
CourseFullException
AlreadyRegisteredException
CourseLimitExceededException
```

Built-in Exception:

```java
InputMismatchException
```

---

## 📋 System Workflow

### Student Workflow

```text
Login
↓
View/Search Courses
↓
Register Course
↓
View Registered Courses
↓
Drop Course (Optional)
↓
View Profile Summary
```

### Admin Workflow

```text
Admin Panel
↓
Add Student
↓
View Students
↓
Add Course
↓
Remove Course
↓
View Courses
```

---

## 📁 Project Structure

```text
CollegeCourseRegistrationSystem
│
├── README.md
├── .gitignore
├── Main.java
├── Person.java
├── Student.java
├── Admin.java
├── Course.java
├── RegistrationService.java
├── CourseFullException.java
├── AlreadyRegisteredException.java
└── CourseLimitExceededException.java
```

---

## 🛠️ Technologies Used

| Technology              | Purpose                    |
| ----------------------- | -------------------------- |
| Java                    | Core Programming Language  |
| OOP Concepts            | Inheritance & Polymorphism |
| Collections Framework   | Data Management            |
| Exception Handling      | Runtime Validation         |
| VS Code / IntelliJ IDEA | Development Environment    |

---

## ▶️ How to Run

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

## 📸 Sample Functionalities

### Student

* Login using Student ID
* Register Course
* Drop Course
* Search Course
* View Profile

### Admin

* Add Student
* View Students
* Add Course
* Remove Course

---

## 🎯 Learning Outcomes

Through this project, the following concepts were implemented and understood:

* Object-Oriented Programming
* Inheritance
* Polymorphism
* Collections Framework
* Custom Exception Handling
* Modular Programming
* Service Layer Design

---

## 👨‍💻 Author

Yash Barai
