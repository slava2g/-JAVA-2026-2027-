package org.example;

class Printer {
    private boolean isBusy = false;

    synchronized void printDocument(String docName) {
        while (isBusy) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Очікування перерване");
            }
        }
        isBusy = true;
        System.out.println("Друк документу: " + docName);
        isBusy = false;
        notifyAll();
    }
}

class PrintTask extends Thread {
    Printer printer;
    String docName;

    PrintTask(Printer printer, String docName) {
        this.printer = printer;
        this.docName = docName;
    }

    @Override
    public void run() {
        printer.printDocument(docName);
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Printer printer = new Printer();

        new PrintTask(printer, "Звіт_1.pdf").start();
        new PrintTask(printer, "Звіт_2.pdf").start();
        new PrintTask(printer, "Звіт_3.pdf").start();
    }
}