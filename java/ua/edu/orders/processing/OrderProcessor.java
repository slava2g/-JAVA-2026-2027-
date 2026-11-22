package ua.edu.orders.processing;

import ua.edu.orders.model.Order;
import ua.edu.orders.model.Product;
import ua.edu.orders.storage.OrderRepository;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderProcessor<T extends Product> {
    private final Order<T> order;
    private final OrderRepository repository;

    public OrderProcessor(Order<T> order, OrderRepository repository) {
        this.order = Objects.requireNonNull(order);
        this.repository = Objects.requireNonNull(repository);
    }

    public ProcessedOrder processOrder() throws OrderProcessingException {
        if (order.id() <= 0) {
            throw new OrderProcessingException(
                    order.id(), "Номер замовлення має бути більшим за нуль"
            );
        }

        if (order.quantity() <= 0) {
            throw new OrderProcessingException(
                    order.id(), "Кількість товару має бути більшою за нуль"
            );
        }

        T product = order.product();
        BigDecimal total = product.getPrice()
                .multiply(BigDecimal.valueOf(order.quantity()));

        if (!repository.saveIfAbsent(order)) {
            throw new OrderProcessingException(
                    order.id(), "Замовлення з таким номером уже оброблено"
            );
        }

        return new ProcessedOrder(
                order.id(), product.getName(), total, Thread.currentThread().getName()
        );
    }
}