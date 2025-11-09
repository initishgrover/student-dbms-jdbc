
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "2246"; // Replace with your PostgreSQL password

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection to PostgreSQL successful!");

            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ PostgreSQL JDBC Driver not found. Add it to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed. Check URL, username, or password.");
            e.printStackTrace();
        }

    }
}
