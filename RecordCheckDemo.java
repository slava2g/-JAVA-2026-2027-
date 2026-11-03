package org.example;

record StudentChecked(String name, int id, double averageGrade) {
    public StudentChecked {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я не може бути пустим");
        }
        if (averageGrade < 0 || averageGrade > 100) {
            throw new IllegalArgumentException("Бал має бути між 0 і 100");
        }
    }
}

public class RecordCheckDemo {
    public static void main(String[] args) {
        StudentChecked student = new StudentChecked("Олексій", 12345, 90.5);
        System.out.println("Студент створений успішно: " + student.name());
    }
}