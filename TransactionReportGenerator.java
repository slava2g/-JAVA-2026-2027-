package org.example;

import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {

    private TransactionReportGenerator() {}

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("\n10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printExpenseCategoryReport(Map<String, Double> categoryExpenses) {
        System.out.println("\n====================================");
        System.out.println("ЗВІТ ВИТРАТ ЗА КАТЕГОРІЯМИ (* = 1000 грн)");
        System.out.println("====================================");

        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();

            int starsCount = (int) (amount / 1000);
            String bar = "*".repeat(Math.max(0, starsCount));

            System.out.printf("%-20s | %8.2f грн | %s%n", category, amount, bar);
        }
        System.out.println("====================================");
    }
}