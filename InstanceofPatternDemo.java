package org.example;

public class InstanceofPatternDemo {
    public static void main(String[] args) {
        Object obj = "Привіт, Java!";
        if (obj instanceof String s) {
            System.out.println("Рядок у верхньому регістрі: " + s.toUpperCase());
        }
    }
}