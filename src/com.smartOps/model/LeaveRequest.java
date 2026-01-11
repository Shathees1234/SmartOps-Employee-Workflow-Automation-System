package com.smartops.model;

public class LeaveRequest {

    private int empId;
    private int leaveDays;
    private String status;

    public LeaveRequest(int empId, int leaveDays, String status) {
        this.empId = empId;
        this.leaveDays = leaveDays;
        this.status = status;
    }
}
