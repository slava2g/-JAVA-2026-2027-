package org.example;

public class SwitchBlockDemo {
    public static void main(String[] args) {
        String courseType = "практика";
        boolean extraResources;
        String category = switch (courseType) {
            case "лекція", "семінар" -> {
                extraResources = false;
                yield "Теоретичний курс";
            }
            case "практика", "лабораторна" -> {
                extraResources = true;
                yield "Практичний курс";
            }
            default -> {
                extraResources = false;
                yield "Інше";
            }
        };
        System.out.println("Категорія курсу: " + category);
        if (extraResources) {
            System.out.println("Необхідна плата за додаткові ресурси.");
        }
    }
}