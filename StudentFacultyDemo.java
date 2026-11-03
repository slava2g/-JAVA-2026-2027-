package org.example;

enum Faculty { Engineering, Law, Medicine, Arts, Other }

public class StudentFacultyDemo {
    public static void main(String[] args) {
        String[] students = {
                "Іван Іваненко", "Марія Шевченко", "Тарас Довженко", "Іван Коваленко"
        };

        for (String student : students) {
            Faculty faculty = switch (student) {
                case "Іван Іваненко" -> Faculty.Engineering;
                case "Марія Шевченко" -> Faculty.Law;
                case "Тарас Довженко" -> Faculty.Medicine;
                default -> Faculty.Other; // Спрацює для Івана Коваленка
            };

            System.out.println(student + " -> " + faculty);
        }
    }
}