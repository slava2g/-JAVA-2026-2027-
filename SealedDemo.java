package org.example;

sealed class Course permits MathCourse, PhysicsCourse {}

final class MathCourse extends Course {}
final class PhysicsCourse extends Course {}

public class SealedDemo {
    public static void main(String[] args) {
        Course c = new MathCourse();
        System.out.println("Об'єкт запечатаного класу створено успішно.");
    }
}