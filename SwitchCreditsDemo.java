package org.example;

public class SwitchCreditsDemo {
    public static void main(String[] args) {
        int credits = 30;
        String status = switch (credits) {
            case 30 -> "Відмінник";
            case 20 -> "Добре";
            case 10 -> "Задовільно";
            default -> "Потребує додаткового навчання";
        };
        System.out.println("Статус студента: " + status);
    }
}