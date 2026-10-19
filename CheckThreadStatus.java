package org.example;

public class CheckThreadStatus {
    public static void main(String[] args) {
        System.out.println("Запуск потоків для перевірки стану.");

        MyThread mt1 = MyThread.createAndStart("Task #1");
        MyThread mt2 = MyThread.createAndStart("Task #2");
        MyThread mt3 = MyThread.createAndStart("Task #3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Головний потік перерваний.");
            }
        } while (mt1.t.isAlive() || mt2.t.isAlive() || mt3.t.isAlive());

        System.out.println("\nУсі потоки завершили роботу.");
        System.out.println("Головний потік завершений.");
    }
}