package com.university.system.doubles;

import java.math.BigDecimal;

public class Ticket {
    private final String clientName;
    private final Price price;
    private final BigDecimal discountRate;
    private final BigDecimal fixedPrice;

    // Конструктор для Dummy (Слайд 16)
    public Ticket(String clientName, BigDecimal fixedPrice) {
        this.clientName = clientName;
        this.fixedPrice = fixedPrice;
        this.price = null;
        this.discountRate = new BigDecimal("0.9");
    }

    // Конструктор для Stub (Слайд 16)
    public Ticket(Price price) {
        this.clientName = "Default";
        this.price = price;
        this.fixedPrice = null;
        this.discountRate = new BigDecimal("0.9");
    }

    // Конструктор для Mock (Слайд 18)
    public Ticket(Price price, BigDecimal discountRate) {
        this.clientName = "Default";
        this.price = price;
        this.fixedPrice = null;
        this.discountRate = discountRate;
    }

    public String getName() {
        return clientName;
    }

    public BigDecimal getDiscountPrice() {
        BigDecimal base = (price != null) ? price.getInitialPrice() : fixedPrice;
        return base.multiply(discountRate).stripTrailingZeros().scale() <= 0
                ? base.multiply(discountRate).setScale(1)
                : base.multiply(discountRate);
    }
}