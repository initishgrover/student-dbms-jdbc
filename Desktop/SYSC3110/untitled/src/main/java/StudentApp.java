import java.sql.*;

public class StudentApp {
    // Database connection info
    private static final String URL = "jdbc:postgresql://localhost:5432/school";
    private static final String USER = "postgres";              // change if different
    private static final String PASSWORD = "2246"; // ← replace with your actual password

    // Open a new connection
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //  Retrieve and display all students
    public static void getAllStudents() {
        String sql = "SELECT * FROM students ORDER BY student_id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- All Students ---");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s | %s%n",
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("enrollment_date"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students.");

        }
    }

    // Add a new student
    public static void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        String sql = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setDate(4, Date.valueOf(enrollmentDate)); // YYYY-MM-DD
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student.");

        }
    }

    //  Update student email
    public static void updateStudentEmail(int studentId, String newEmail) {
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newEmail);
            pstmt.setInt(2, studentId);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Email updated successfully.");
            else
                System.out.println("No student found with that ID.");
        } catch (SQLException e) {
            System.out.println("Error updating email.");

        }
    }

    //  Delete a student
    public static void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("️ No student found with that ID.");
        } catch (SQLException e) {
            System.out.println("Error deleting student.");

        }
    }

    // Main method — runs everything for the demo
    public static void main(String[] args) {
        // Show current data
        getAllStudents();

        // Add a new student
        addStudent("Alicey", "Johnson", "alicey.johnson@example.com", "2023-09-03");

        // Verify addition
        getAllStudents();

        // Update Alice's email
       updateStudentEmail(12, "alice.new@example.com"); // assuming her id = 4 after insert

        // Verify update
        getAllStudents();

        // Delete Alice
        deleteStudent(14);

        // Verify delete
        getAllStudents();
    }
}
