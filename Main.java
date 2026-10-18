package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "pr2.csv";

        DataReader reader = new TransactionCSVReader();
        List<Transaction> transactions = reader.readTransactions(filePath);

        System.out.println("Зчитано транзакцій: " + transactions.size());

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        Map<String, Double> categoryExpenses = TransactionAnalyzer.groupExpensesByCategory(transactions);
        TransactionReportGenerator.printExpenseCategoryReport(categoryExpenses);
    }
}