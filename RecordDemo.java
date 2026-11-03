package org.example;

record StudentRecord(String name, int id, double averageGrade) {}

public class RecordDemo {
    public static void main(String[] args) {
        StudentRecord student = new StudentRecord("Олексій", 12345, 90.5);
        System.out.println("Ім'я: " + student.name());
        System.out.println("ID: " + student.id());
        System.out.println("Середній бал: " + student.averageGrade());
    }
}