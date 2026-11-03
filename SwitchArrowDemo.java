package org.example;

public class SwitchArrowDemo {
    public static void main(String[] args) {
        String activityType = "лабораторна";
        String assessmentType = switch (activityType) {
            case "лекція", "семінар" -> "тестування";
            case "практика", "лабораторна" -> "лабораторна робота";
            case "курсовий проєкт" -> "Іспит";
            default -> "інше";
        };
        System.out.println("Тип оцінювання: " + assessmentType);
    }
}