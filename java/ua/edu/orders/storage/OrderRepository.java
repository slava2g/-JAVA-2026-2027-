package ua.edu.orders.storage;

import ua.edu.orders.model.Order;
import ua.edu.orders.storage.internal.ConcurrentOrderStore;

import java.util.List;

public final class OrderRepository {
    private final ConcurrentOrderStore store = new ConcurrentOrderStore();

    public boolean saveIfAbsent(Order<?> order) {
        return store.saveIfAbsent(order);
    }

    public List<Order<?>> findAll() {
        return store.findAll();
    }
}