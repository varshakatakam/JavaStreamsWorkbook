package com.training.dto;

public class Inventory_P6 {
    private String productId;
    private int quantity;
    public Inventory_P6(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public String getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
}
