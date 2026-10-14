package com.training.dto;

public class AccountTransaction_P10 {

    private String accountId;
    private String transactionType;
    private double amount;

    public AccountTransaction_P10(String accountId,
                                  String transactionType,
                                  double amount) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    public String getAccountId() {
        return accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}