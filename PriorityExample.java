package org.example;

class PriorityTask implements Runnable {
    String threadName;
    Thread thrd;

    PriorityTask(String name) {
        threadName = name;
        thrd = new Thread(this, name);
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadName + " запущено.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Поток " + threadName + " виконується, крок " + i);
        }
        System.out.println("Поток " + threadName + " завершено.");
    }
}

public class PriorityExample {
    public static void main(String[] args) {
        PriorityTask task1 = new PriorityTask("Високий пріоритет");
        PriorityTask task2 = new PriorityTask("Низький пріоритет");

        task1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
        task2.thrd.setPriority(Thread.NORM_PRIORITY - 2);

        task1.thrd.start();
        task2.thrd.start();
    }
}