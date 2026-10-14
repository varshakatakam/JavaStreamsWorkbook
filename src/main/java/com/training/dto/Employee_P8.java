package com.training.dto;

public class Employee_P8 {

    private int employeeId;
    private String employeeName;
    private Integer managerId;
    public Employee_P8(int employeeId, String employeeName, Integer managerId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
    }
    public int getEmployeeId() {

        return employeeId;
    }
    public String getEmployeeName() {

        return employeeName;
    }
    public Integer getManagerId() {

        return managerId;
    }

}
