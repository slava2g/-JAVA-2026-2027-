package org.example;

public class SwitchPatternMatchDemo {
    public static void main(String[] args) {
        Object obj = "Java";
        switch (obj) {
            case Integer i -> System.out.println("Ціле число: " + i);
            case String s -> System.out.println("Рядок: " + s);
            case null -> System.out.println("Немає значення");
            default -> System.out.println("Інший тип");
        }
    }
}