package com.gla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class EmployeeCRUD {

    public static void main(String[] args) {
        try {
            // Database connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company", "root", "password");

            Statement stmt = con.createStatement();

            // 1. Create Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "salary DOUBLE)");

            // 2. Insert Employee
            stmt.executeUpdate("INSERT INTO employee VALUES (1, 'Amit', 35000)");
            stmt.executeUpdate("INSERT INTO employee VALUES (2, 'Riya', 12000)");
            stmt.executeUpdate("INSERT INTO employee VALUES (3, 'John', 50000)");

            // 3. Read (salary > 30000)
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE salary > 30000");
            System.out.println("Employees with salary > 30000:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getDouble("salary"));
            }

            // 4. Update (Increase salary by 10%)
            stmt.executeUpdate("UPDATE employee SET salary = salary * 1.10 WHERE id = 1");

            // 5. Delete (salary < 15000)
            stmt.executeUpdate("DELETE FROM employee WHERE salary < 15000");

            System.out.println("Operations completed successfully.");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}