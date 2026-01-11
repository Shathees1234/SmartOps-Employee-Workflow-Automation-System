package com.smartops.service;

import java.sql.*;
import java.util.Scanner;
import com.smartops.util.DBConnection;
import com.smartops.util.AIRuleEngine;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    public void registerEmployee() {
        try {
            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO employees VALUES (?, ?, ?, 20, 0)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.executeUpdate();

            System.out.println("Employee Registered Successfully");
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void applyLeave() {
        try {
            System.out.print("Employee ID: ");
            int empId = sc.nextInt();

            System.out.print("Leave Days: ");
            int days = sc.nextInt();

            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 =
                con.prepareStatement("SELECT total_leave, used_leave FROM employees WHERE emp_id=?");
            ps1.setInt(1, empId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Employee not found");
                return;
            }

            int remaining = rs.getInt(1) - rs.getInt(2);
            String status = AIRuleEngine.evaluateLeave(days, remaining);

            PreparedStatement ps2 =
                con.prepareStatement(
                    "INSERT INTO employee_requests(emp_id, leave_days, status) VALUES (?, ?, ?)");
            ps2.setInt(1, empId);
            ps2.setInt(2, days);
            ps2.setString(3, status);
            ps2.executeUpdate();

            if (status.equals("AUTO-APPROVED")) {
                PreparedStatement ps3 =
                    con.prepareStatement(
                        "UPDATE employees SET used_leave = used_leave + ? WHERE emp_id=?");
                ps3.setInt(1, days);
                ps3.setInt(2, empId);
                ps3.executeUpdate();
            }

            System.out.println("Leave Status: " + status);
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewMyRequests() {
        try {
            System.out.print("Employee ID: ");
            int empId = sc.nextInt();

            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM employee_requests WHERE emp_id=?");
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    "Days: " + rs.getInt("leave_days") +
                    " | Status: " + rs.getString("status"));
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
