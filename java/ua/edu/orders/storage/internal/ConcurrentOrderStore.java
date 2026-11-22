package ua.edu.orders.storage.internal;

import ua.edu.orders.model.Order;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class ConcurrentOrderStore {
    private final ConcurrentHashMap<Long, Order<?>> orders = new ConcurrentHashMap<>();

    public boolean saveIfAbsent(Order<?> order) {
        return orders.putIfAbsent(order.id(), order) == null;
    }

    public List<Order<?>> findAll() {
        return orders.values().stream()
                .sorted(Comparator.comparingLong(Order::id))
                .toList();
    }
}