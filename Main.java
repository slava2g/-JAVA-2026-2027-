package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("=== КАЛЬКУЛЯТОР (Практична робота 3) ===");
        System.out.println("Студент: Шашенко Вячеслав Олексійович");
        System.out.println("Доступні операції: +, -, *, /, sqrt (квадратний корінь)");

        try {
            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.next();

            double a = 0, b = 0;

            if (operation.equalsIgnoreCase("sqrt")) {
                System.out.print("Введіть число: ");
                a = scanner.nextDouble();
            } else {
                System.out.print("Введіть перше число: ");
                a = scanner.nextDouble();
                System.out.print("Введіть друге число: ");
                b = scanner.nextDouble();
            }

            double result = 0;

            switch (operation) {
                case "+":
                    result = calculator.add(a, b);
                    break;
                case "-":
                    result = calculator.subtract(a, b);
                    break;
                case "*":
                    result = calculator.multiply(a, b);
                    break;
                case "/":
                    result = calculator.divide(a, b);
                    break;
                case "sqrt":
                    result = calculator.squareRoot(a);
                    break;
                default:
                    throw new InvalidInputException("Введено невідому операцію: '" + operation + "'");
            }

            System.out.println("Результат: " + result);

        } catch (ArithmeticException e) {
            System.err.println("Арифметична помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.err.println("Помилка вхідних даних (власний виняток): " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Помилка формату: введено рядок або сторонній символ замість числа!");
        } catch (Exception e) {
            System.err.println("Сталася непередбачена помилка: " + e.getMessage());
        } finally {
            System.out.println("[INFO] Повідомлення: обробку запиту завершено.");
            scanner.close();
        }
    }
}