package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransactionCSVReaderTest {

    @Test
    public void testReadTransactionsFromCSV() {
        String filePath = "pr2.csv";
        DataReader reader = new TransactionCSVReader();

        List<Transaction> transactions = reader.readTransactions(filePath);

        Assertions.assertNotNull(transactions, "Список транзакций не должен быть null");
        Assertions.assertFalse(transactions.isEmpty(), "Файл должен содержать хотя бы одну транзакцию");
    }
}