package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private TransactionAnalyzer() {}

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        int count = 0;
        for (Transaction t : transactions) {
            if (t.getDate().contains(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Transaction> findMinMaxExpensesInPeriod(List<Transaction> transactions, String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);

        List<Transaction> filtered = transactions.stream()
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMATTER);
                    return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                            (date.isEqual(endDate) || date.isBefore(endDate)) &&
                            t.getAmount() < 0;
                })
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            return List.of();
        }

        Transaction maxExpense = filtered.stream().min(Comparator.comparing(Transaction::getAmount)).orElse(null); // Самая крупная сумма по модулю
        Transaction minExpense = filtered.stream().max(Comparator.comparing(Transaction::getAmount)).orElse(null); // Самая мелкая сумма по модулю

        return List.of(maxExpense, minExpense);
    }

    public static Map<String, Double> groupExpensesByCategory(List<Transaction> transactions) {
        Map<String, Double> categoryMap = new HashMap<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                String category = t.getDescription();
                double amount = Math.abs(t.getAmount());
                categoryMap.put(category, categoryMap.getOrDefault(category, 0.0) + amount);
            }
        }
        return categoryMap;
    }
}