package com.university.system;

public class RevenueCalculator {
    private boolean running = false;

    public void reset() {
        running = false;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public int calculate(TicketRevenue ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("TicketRevenue cannot be null");
        }
        return ticket.getTickets() * ticket.getPrice();
    }
}