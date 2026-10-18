package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {

    @Test
    public void testCalculateTotalBalance() {
        Transaction t1 = new Transaction("01-01-2023", 100.0, "Дохід");
        Transaction t2 = new Transaction("02-01-2023", -50.0, "Витрата");
        List<Transaction> transactions = Arrays.asList(t1, t2);

        double result = TransactionAnalyzer.calculateTotalBalance(transactions);
        Assertions.assertEquals(50.0, result);
    }

    @Test
    public void testFindTopExpenses() {
        Transaction t1 = new Transaction("01-12-2023", -100.0, "Аптека");
        Transaction t2 = new Transaction("02-12-2023", -5000.0, "Аренда");
        Transaction t3 = new Transaction("03-12-2023", -200.0, "Кафе");
        Transaction t4 = new Transaction("04-12-2023", 10000.0, "Зарплата"); // Доход (должен отфильтроваться)

        List<Transaction> transactions = Arrays.asList(t1, t2, t3, t4);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        Assertions.assertEquals(3, topExpenses.size(), "Должно быть ровно 3 расходы");
        Assertions.assertEquals(-5000.0, topExpenses.get(0).getAmount(), "Первым должен идти самый крупный расход (-5000)");
    }
}