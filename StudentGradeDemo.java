package org.example;

record StudentGrade(String name, double grade) {
    public double getDiscountedGrade(double percentage) {
        return grade - (grade * percentage / 100.0);
    }
}

public class StudentGradeDemo {
    public static void main(String[] args) {
        StudentGrade sg = new StudentGrade("Марія", 90.0);
        System.out.println("Знижена оцінка: " + sg.getDiscountedGrade(10));
    }
}