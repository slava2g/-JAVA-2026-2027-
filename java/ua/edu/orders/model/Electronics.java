package ua.edu.orders.model;

import lombok.Builder;

import java.math.BigDecimal;

public final class Electronics extends Product {
    private final int warrantyMonths;

    @Builder
    private Electronics(String name, BigDecimal price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}