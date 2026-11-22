package ua.edu.orders.processing;

public final class OrderProcessingException extends Exception {
    private final long orderId;

    public OrderProcessingException(long orderId, String message) {
        super(message);
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }
}