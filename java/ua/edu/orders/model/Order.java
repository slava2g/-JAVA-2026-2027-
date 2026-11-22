package ua.edu.orders.model;

import java.util.Objects;

public record Order<T extends Product>(long id, T product, int quantity) {
    public Order {
        Objects.requireNonNull(product, "Замовлення повинне містити товар");
    }
}