package org.example;

public sealed abstract class CourseAbstract permits MathAbs, PhysicsAbs {
    public abstract void courseDetails();
}

final class MathAbs extends CourseAbstract {
    public void courseDetails() {
        System.out.println("Це курс з математики.");
    }
}

final class PhysicsAbs extends CourseAbstract {
    public void courseDetails() {
        System.out.println("Це курс з фізики.");
    }
}

class CourseAbstractDemo {
    public static void main(String[] args) {
        CourseAbstract c = new MathAbs();
        c.courseDetails();
    }
}