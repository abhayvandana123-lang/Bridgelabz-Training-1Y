package com.gla;

import java.sql.*;

public class BankManager {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        createTable();

        // Create accounts
        addAccount(101, "Amit", 15000);
        addAccount(102, "Riya", 8000);
        addAccount(103, "Rahul", 25000);

        // Read accounts with balance > 10000
        showRichAccounts();

        // Deposit and Withdraw
        deposit(102, 5000);   // add money
        withdraw(101, 3000);  // subtract money

        // Delete account
        deleteAccount(103);
    }

    // 1. Create Table
    static void createTable() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String query = "CREATE TABLE IF NOT EXISTS accounts(" +
                    "accNo INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "balance DOUBLE)";

            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Create Account
    static void addAccount(int accNo, String name, double balance) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO accounts VALUES (?, ?, ?)")) {

            ps.setInt(1, accNo);
            ps.setString(2, name);
            ps.setDouble(3, balance);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Read (balance > 10000)
    static void showRichAccounts() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM accounts WHERE balance > ?")) {

            ps.setDouble(1, 10000);
            ResultSet rs = ps.executeQuery();

            System.out.println("Accounts with balance > 10000:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                                   rs.getString(2) + " " +
                                   rs.getDouble(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Deposit
    static void deposit(int accNo, double amount) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE accounts SET balance = balance + ? WHERE accNo = ?")) {

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Withdraw
    static void withdraw(int accNo, double amount) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE accounts SET balance = balance - ? WHERE accNo = ?")) {

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Delete Account
    static void deleteAccount(int accNo) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM accounts WHERE accNo = ?")) {

            ps.setInt(1, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}