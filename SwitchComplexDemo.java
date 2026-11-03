package org.example;

public class SwitchComplexDemo {
    public static void main(String[] args) {
        int errorCode = -1;
        boolean normalCompletion = false;
        String message = switch (errorCode) {
            case -1 -> getErrorMessage();
            case 0 -> {
                normalCompletion = true;
                yield "Завершено без помилок";
            }
            case 1 -> "Попередження: необхідна перевірка";
            default -> "Невідомий стан";
        };
        System.out.println("Повідомлення: " + message);
    }

    public static String getErrorMessage() {
        return "Помилка: неправильні дані.";
    }
}