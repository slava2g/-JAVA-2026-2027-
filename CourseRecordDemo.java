package org.example;

record CourseRecord(String courseName, int courseId, double creditHours) {
    public CourseRecord {
        if (courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва курсу не може бути порожньою.");
        }
    }
    public CourseRecord(String courseName, int courseId, String creditHours) {
        this(courseName, courseId, Double.parseDouble(creditHours));
    }
}

public class CourseRecordDemo {
    public static void main(String[] args) {
        CourseRecord cr = new CourseRecord("Java", 101, "4.5");
        System.out.println("Курс: " + cr.courseName() + ", години: " + cr.creditHours());
    }
}