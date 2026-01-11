package com.smartops.model;

public class Employee {

    private int empId;
    private String name;
    private String department;
    private int totalLeave;
    private int usedLeave;

    public Employee(int empId, String name, String department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.totalLeave = 20;
        this.usedLeave = 0;
    }

    public int getRemainingLeave() {
        return totalLeave - usedLeave;
    }
}
