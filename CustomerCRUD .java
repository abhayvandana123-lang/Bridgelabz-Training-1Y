package com.gla;

import java.sql.*;

public class CustomerCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        createTable();

        // Add customers
        addCustomer(1, "Amit Sharma", "9876543210");
        addCustomer(2, "Riya Singh", "9123456780");
        addCustomer(3, "Aman Verma", "9988776655");

        // Search by name
        searchCustomer("A");

        // Update phone number
        updatePhone(2, "9000000000");

        // Delete customer
        deleteCustomer(3);
    }

    // 1. Create Table
    static void createTable() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS customers(" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "phone VARCHAR(15))";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Insert Customer
    static void addCustomer(int id, String name, String phone) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO customers VALUES (?, ?, ?)")) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Search by Name (LIKE)
    static void searchCustomer(String keyword) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM customers WHERE name LIKE ?")) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            System.out.println("Search Results:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                                   rs.getString(2) + " " +
                                   rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Update Phone Number
    static void updatePhone(int id, String newPhone) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE customers SET phone = ? WHERE id = ?")) {

            ps.setString(1, newPhone);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Customer
    static void deleteCustomer(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM customers WHERE id = ?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}