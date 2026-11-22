package ua.edu.orders.model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {
    private final String name;
    private final BigDecimal price;

    protected Product(String name, BigDecimal price) {
        this.name = Objects.requireNonNull(name, "Назва товару обов’язкова");
        this.price = Objects.requireNonNull(price, "Ціна товару обов’язкова");

        if (name.isBlank() || price.signum() < 0) {
            throw new IllegalArgumentException("Вкажіть назву та невід’ємну ціну товару");
        }
    }

    public final String getName() {
        return name;
    }

    public final BigDecimal getPrice() {
        return price;
    }
}