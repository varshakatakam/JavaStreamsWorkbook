package com.training.dto;

public class Transaction_P1 {

    private String customerId;
    private String type;
    private double amount;

    public Transaction_P1(String customerId,
                          String type,
                          double amount){
        this.customerId=customerId;
        this.type=type;
        this.amount=amount;
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }
}
