package ua.edu.orders.model;

import lombok.Builder;

import java.math.BigDecimal;

public final class Clothing extends Product {
    private final String size;
    private final String color;

    @Builder
    private Clothing(String name, BigDecimal price, String size, String color) {
        super(name, price);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}