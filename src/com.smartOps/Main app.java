package com.smartops;

import java.util.Scanner;
import com.smartops.service.EmployeeService;
import com.smartops.service.AdminService;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        AdminService adminService = new AdminService();

        while (true) {
            System.out.println("\n=== SmartOps Employee Management ===");
            System.out.println("1. Register Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. View My Leave Requests");
            System.out.println("4. Admin View All Requests");
            System.out.println("5. Admin Approve / Reject");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> employeeService.registerEmployee();
                case 2 -> employeeService.applyLeave();
                case 3 -> employeeService.viewMyRequests();
                case 4 -> adminService.viewAllRequests();
                case 5 -> adminService.updateRequestStatus();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
