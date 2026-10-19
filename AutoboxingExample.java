package org.example;

public class AutoboxingExample {

    static void processStudentID(Integer id) {
        System.out.println("Оброблено студентський ID: " + id);
    }

    static int getBonusPoints() {
        return 5;
    }

    public static void main(String[] args) {
        Integer studentScore = 85;
        int finalScore = studentScore + 5;
        System.out.println("Остаточний бал студента: " + finalScore);

        processStudentID(12345);

        int bonus = getBonusPoints();
        System.out.println("Бонусні бали: " + bonus);

        Integer gradeLevel = 3;
        switch (gradeLevel) {
            case 1: System.out.println("Перший курс"); break;
            case 2: System.out.println("Другий курс"); break;
            case 3: System.out.println("Третій курс"); break;
            default: System.out.println("Курс не визначено");
        }
    }
}