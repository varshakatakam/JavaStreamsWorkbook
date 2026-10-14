package com.training.dto;

public class Order_P2 {

    private String orderId;
    private String customerId;
    private double amount;

    public Order_P2(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public double getAmount() {
        return amount;
    }
}
