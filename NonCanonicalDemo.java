package org.example;

record StudentNonCanonicalRecord(String name, int studentID, double gpa) {
    public StudentNonCanonicalRecord(String name, int studentID, String gpa) {
        this(name, studentID, Double.parseDouble(gpa));
    }
}

public class NonCanonicalDemo {
    public static void main(String[] args) {
        StudentNonCanonicalRecord sr = new StudentNonCanonicalRecord("Іван", 111, "3.8");
        System.out.println("GPA: " + sr.gpa());
    }
}
