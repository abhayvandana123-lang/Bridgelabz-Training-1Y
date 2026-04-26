package com.gla;

import java.sql.*;

public class LibraryManager {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        createTable();

        // Insert books
        addBook(1, "Java Basics", "James", "Available");
        addBook(2, "DBMS Guide", "Korth", "Available");
        addBook(3, "Python Intro", "Guido", "Issued");

        // Show available books
        showAvailableBooks();

        // Issue a book
        issueBook(2);

        // Delete lost/damaged book
        deleteBook(3);
    }

    // 1. Create Table
    static void createTable() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS books(" +
                    "id INT PRIMARY KEY, " +
                    "title VARCHAR(100), " +
                    "author VARCHAR(50), " +
                    "status VARCHAR(10))";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Insert Book
    static void addBook(int id, String title, String author, String status) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO books VALUES (?, ?, ?, ?)")) {

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, status);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Read Available Books
    static void showAvailableBooks() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM books WHERE status = ?")) {

            ps.setString(1, "Available");
            ResultSet rs = ps.executeQuery();

            System.out.println("Available Books:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                                   rs.getString(2) + " " +
                                   rs.getString(3) + " " +
                                   rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Update Status to Issued
    static void issueBook(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE books SET status = ? WHERE id = ?")) {

            ps.setString(1, "Issued");
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Book
    static void deleteBook(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM books WHERE id = ?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}