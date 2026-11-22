package ua.edu.orders.threading;

import ua.edu.orders.model.Clothing;
import ua.edu.orders.model.Electronics;
import ua.edu.orders.model.Order;
import ua.edu.orders.processing.OrderProcessingException;
import ua.edu.orders.processing.OrderProcessor;
import ua.edu.orders.processing.ProcessedOrder;
import ua.edu.orders.storage.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Main {
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) throws ExecutionException {
        OrderRepository repository = new OrderRepository();
        List<Order<?>> orders = new DemoOrders().createOrders();
        List<Future<ProcessedOrder>> results = new ArrayList<>();

        System.out.printf("Отримано замовлень: %d. Потоків обробки: %d.%n",
                orders.size(), THREAD_COUNT);

        try (OrderExecutor executor = new OrderExecutor(THREAD_COUNT)) {
            for (Order<?> order : orders) {
                results.add(
                        executor.submit(new OrderProcessor<>(order, repository)::processOrder)
                );
            }

            for (Future<ProcessedOrder> result : results) {
                printResult(result);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Очікування результатів перервано.");
            return;
        }

        List<Order<?>> savedOrders = repository.findAll();

        long electronicsCount = savedOrders.stream()
                .filter(order -> order.product() instanceof Electronics)
                .count();

        long clothingCount = savedOrders.stream()
                .filter(order -> order.product() instanceof Clothing)
                .count();

        System.out.printf("%nЗбережено замовлень: %d. Електроніка: %d. Одяг: %d.%n",
                savedOrders.size(), electronicsCount, clothingCount);
    }

    private static void printResult(Future<ProcessedOrder> future)
            throws InterruptedException, ExecutionException {
        try {
            ProcessedOrder result = future.get();
            System.out.printf("[%s] №%d | %s | %s грн%n",
                    result.threadName(),
                    result.orderId(),
                    result.productName(),
                    result.total().toPlainString());
        } catch (ExecutionException e) {
            if (e.getCause() instanceof OrderProcessingException error) {
                System.out.printf("Замовлення №%d відхилено: %s.%n",
                        error.getOrderId(), error.getMessage());
                return;
            }

            throw e;
        }
    }
}