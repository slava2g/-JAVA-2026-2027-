package org.example;

class MyThread implements Runnable {
    Thread t;
    String threadName;

    MyThread(String name) {
        threadName = name;
        t = new Thread(this, name);
        System.out.println("Поток " + threadName + " створено.");
    }

    public static MyThread createAndStart(String name) {
        MyThread myThread = new MyThread(name);
        myThread.t.start();
        return myThread;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadName + " запущено.");
        try {
            for (int count = 0; count < 5; count++) {
                Thread.sleep(400);
                System.out.println("В потоці " + threadName + " значення count = " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(threadName + " перервано.");
        }
        System.out.println("Поток " + threadName + " завершено.");
    }
}

public class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Запуск потоків.");

        MyThread mt1 = MyThread.createAndStart("Child #1");
        MyThread mt2 = MyThread.createAndStart("Child #2");
        MyThread mt3 = MyThread.createAndStart("Child #3");

        try {
            mt1.t.join();
            mt2.t.join();
            mt3.t.join();
        } catch (InterruptedException exc) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("Головний потік завершено.");
    }
}