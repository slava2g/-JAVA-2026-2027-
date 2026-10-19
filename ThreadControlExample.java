package org.example;

class ControlledThread implements Runnable {
    private Thread thrd;
    private boolean suspended = false;
    private boolean stopped = false;

    ControlledThread(String name) {
        thrd = new Thread(this, name);
        thrd.start();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }

    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    @Override
    public void run() {
        System.out.println("Поток " + thrd.getName() + " запущено.");
        try {
            for (int i = 1; i < 10; i++) {
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
                System.out.print(i + " ");
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("Потік перервано.");
        }
        System.out.println("\nПоток " + thrd.getName() + " завершено.");
    }
}

public class ThreadControlExample {
    public static void main(String[] args) {
        ControlledThread ct1 = new ControlledThread("Child #1");

        try {
            Thread.sleep(1000);
            ct1.mysuspend();
            System.out.println("\nПотік зупинено.");

            Thread.sleep(1000);
            ct1.myresume();
            System.out.println("Потік відновлено.");

            Thread.sleep(1000);
            ct1.mystop();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }
    }
}