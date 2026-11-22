package ua.edu.orders.processing;

import java.math.BigDecimal;

public record ProcessedOrder(
        long orderId,
        String productName,
        BigDecimal total,
        String threadName
) {
}