package il.cshaifasweng.OCSFMediatorExample.entities;

import il.cshaifasweng.OCSFMediatorExample.entities.CatalogItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO {


    private Connection connect() throws SQLException {
         final String DB_URL = "jdbc:mysql://localhost:3306/itemsDB?useSSL=false&serverTimezone=UTC";
         final String DB_USER = "root";
         final String DB_PASSWORD = "Krm51102@";

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public CatalogItem getItemById(int id) {
        String sql = "SELECT * FROM LItems WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CatalogItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<CatalogItem> getAllItems() {
        List<CatalogItem> items = new ArrayList<>();
        String sql = "SELECT * FROM LItems";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                items.add(new CatalogItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("price")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void updatePrice(int id, double newPrice) {
        String sql = "UPDATE LItems SET price = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
