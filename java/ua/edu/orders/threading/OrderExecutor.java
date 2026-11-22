package ua.edu.orders.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final class OrderExecutor implements AutoCloseable {
    private final ExecutorService executor;

    OrderExecutor(int threadCount) {
        AtomicInteger threadNumber = new AtomicInteger();

        executor = Executors.newFixedThreadPool(
                threadCount,
                task -> new Thread(task, "order-worker-" + threadNumber.incrementAndGet())
        );
    }

    <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    @Override
    public void close() {
        executor.close();
    }
}