package org.example;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Спроба ділення на нуль неможлива!");
        }
        return a / b;
    }

    public double squareRoot(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Неможливо обчислити квадратний корінь з від'ємного числа (" + a + ")!");
        }
        return Math.sqrt(a);
    }
}