package org.example;

public sealed interface CourseIF permits MathIf, PhysicsIf {
    String courseName();
}

final class MathIf implements CourseIF {
    public String courseName() { return "Курс математики"; }
}

final class PhysicsIf implements CourseIF {
    public String courseName() { return "Курс фізики"; }
}

class CourseIfDemo {
    public static void main(String[] args) {
        CourseIF c = new MathIf();
        System.out.println(c.courseName());
    }
}