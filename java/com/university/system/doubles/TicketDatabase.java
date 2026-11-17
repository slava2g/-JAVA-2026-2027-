package com.university.system.doubles;

public interface TicketDatabase {
    Ticket findByName(String name);
    void insert(Ticket ticket);
    int count();
}