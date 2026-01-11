package com.smartops.service;

import java.sql.*;
import java.util.Scanner;
import com.smartops.util.DBConnection;

public class AdminService {

    Scanner sc = new Scanner(System.in);

    public void viewAllRequests() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee_requests");

            while (rs.next()) {
                System.out.println(
                    "ReqID: " + rs.getInt("id") +
                    " | EmpID: " + rs.getInt("emp_id") +
                    " | Days: " + rs.getInt("leave_days") +
                    " | Status: " + rs.getString("status"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRequestStatus() {
        try {
            System.out.print("Request ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New Status (APPROVED / REJECTED): ");
            String status = sc.nextLine();

            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE employee_requests SET status=? WHERE id=?");
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Status Updated");
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
