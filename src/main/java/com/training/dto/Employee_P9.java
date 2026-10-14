package com.training.dto;

public class Employee_P9 {

    private String employeeName;
    private String department;
    private int experience;
    private double rating;


    public Employee_P9(String employeeName, String department,
                       int experience, double rating) {
        this.employeeName = employeeName;
        this.department = department;
        this.experience = experience;
        this.rating = rating;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperience() {
        return experience;
    }

    public double getRating() {
        return rating;
    }

}