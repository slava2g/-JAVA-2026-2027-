package com.university.system;

import java.math.BigDecimal;

public class TicketRevenue {
    private static final int TICKET_PRICE = 50;
    private final int tickets;
    private final int price;

    public TicketRevenue() {
        this.tickets = 0;
        this.price = TICKET_PRICE;
    }

    public TicketRevenue(int tickets, int price) {
        this.tickets = tickets;
        this.price = price;
    }

    public int getTickets() {
        return tickets;
    }

    public int getPrice() {
        return price;
    }

    // Приклад зі слайду 10
    public int calculateRevenue(int ticketsSold) {
        if (ticketsSold < 0 || ticketsSold > 200) {
            throw new IllegalArgumentException("Невірна кількість квитків");
        }
        return 50 * ticketsSold;
    }

    // Приклад зі слайдів 11–14 (з перевіркою граничних значень < 0 та > 100)
    public BigDecimal estimateTotalRevenue(int numberOfTicketsSold) {
        if (numberOfTicketsSold < 0 || numberOfTicketsSold > 100) {
            throw new IllegalArgumentException("Кількість квитків має бути від 0 до 100");
        }
        if (numberOfTicketsSold == 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(TICKET_PRICE * numberOfTicketsSold);
    }
}