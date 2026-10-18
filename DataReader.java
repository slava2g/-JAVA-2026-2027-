package org.example;

import java.util.List;

public interface DataReader {
    List<Transaction> readTransactions(String filePath);
}