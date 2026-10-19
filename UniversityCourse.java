package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CourseInfo {
    String courseName();
    int year();
}

@CourseInfo(courseName = "Java Programming", year = 2026)
public class UniversityCourse {

    @Deprecated
    public void oldMethod() {
        System.out.println("Це застарілий метод.");
    }

    public static void main(String[] args) {
        UniversityCourse course = new UniversityCourse();
        course.oldMethod();
        System.out.println("Анотації успішно застосовані!");
    }
}
