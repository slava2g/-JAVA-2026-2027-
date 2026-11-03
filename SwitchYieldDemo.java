package org.example;

public class SwitchYieldDemo {
    public static void main(String[] args) {
        String subjectType = "практика";
        String assessmentType = switch (subjectType) {
            case "лекція", "семінар" -> { yield "тест"; }
            case "практика", "лабораторна" -> { yield "лабораторна робота"; }
            case "курсовий проєкт" -> { yield "іспит"; }
            default -> { yield "інше"; }
        };
        System.out.println("Тип оцінювання для дисципліни: " + assessmentType);
    }
}