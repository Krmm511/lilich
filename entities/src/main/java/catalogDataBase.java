package il.cshaifasweng.OCSFMediatorExample.server;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class catalogDataBase {
    private static final String DB_URL = "jdbc:sqlite:catalog.db";

    public static Connection connect() throws SQLException {
        System.out.println("Connecting to: " + DB_URL);
        System.out.println("Absolute path: " + new java.io.File(DB_URL).getAbsolutePath()); // :white_check_mark: Add this line
        System.out.println("DB location: " + new java.io.File("catalog.db").getAbsolutePath());
        return DriverManager.getConnection(DB_URL);
    }


    public static void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS catalog (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "type TEXT," +
                "price REAL)";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Catalog table initialized.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}