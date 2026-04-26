package com.gla;

import java.sql.*;

public class ProductCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        createTable();

        // Insert products
        addProduct(101, "Laptop", 5);
        addProduct(102, "Mouse", 25);
        addProduct(103, "Keyboard", 8);

        // Read low stock
        displayLowStock();

        // Update quantity (adding stock)
        updateQuantity(101, 10); // add 10 more to Laptop

        // Delete discontinued product
        deleteProduct(102); // delete Mouse
    }

    // 1. Create Table
    static void createTable() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS product(" +
                           "pid INT PRIMARY KEY, pname VARCHAR(50), qty INT)";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Insert Products
    static void addProduct(int pid, String pname, int qty) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO product VALUES (?, ?, ?)")) {

            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setInt(3, qty);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Read Low Stock (qty < 10)
    static void displayLowStock() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM product WHERE qty < ?")) {

            ps.setInt(1, 10);
            ResultSet rs = ps.executeQuery();

            System.out.println("Low Stock Products:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                                   rs.getString(2) + " " +
                                   rs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Update Quantity (Add stock)
    static void updateQuantity(int pid, int addedQty) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE product SET qty = qty + ? WHERE pid = ?")) {

            ps.setInt(1, addedQty);
            ps.setInt(2, pid);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Product
    static void deleteProduct(int pid) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM product WHERE pid = ?")) {

            ps.setInt(1, pid);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}