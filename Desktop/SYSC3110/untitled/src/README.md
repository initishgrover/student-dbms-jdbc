# Assignment 3 - Question 1 Author Nitish Grover
## Database Interaction with PostgreSQL and Application Programming

### 📘 Overview
This project connects a Java application to a PostgreSQL database using JDBC to perform CRUD 
(Create, Read, Update, Delete) operations on a `students` table.  


---

### 🧱 Database Schema
**Table Name:** `students`

| Column Name     | Data Type | Constraints                 |
|-----------------|------------|------------------------------|
| student_id      | SERIAL     | PRIMARY KEY, AUTO-INCREMENT  |
| first_name      | TEXT       | NOT NULL                     |
| last_name       | TEXT       | NOT NULL                     |
| email           | TEXT       | NOT NULL, UNIQUE             |
| enrollment_date | DATE       |                              |

---

### Initial Data
```sql
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

Setup Instructions
1. Database Setup

Open pgAdmin 4 and create a new database (e.g., school).

Run the schema and initial data SQL commands above.

Verify the data by running:

SELECT * FROM students;

2. Project Setup (IntelliJ IDEA)

Open IntelliJ IDEA and create a new Maven project.

Add the PostgreSQL JDBC driver to your pom.xml dependencies:

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.8</version>
</dependency>


Place your Java source file (StudentApp.java) in the src/main/java directory.

Update the database connection details in your code if needed:

private static final String URL = "jdbc:postgresql://localhost:5432/university";
private static final String USER = "postgres";
private static final String PASSWORD = "yourpassword";

3. Run the Application

Compile and run StudentApp.java

it should compile and runn succesfully now call those 4 CRUD functions in main to see it works exactly how
we expected it to work or not 

if doesn't work properly refer to the video below
**Video Link:** https://youtu.be/tEbu0E_uanA

