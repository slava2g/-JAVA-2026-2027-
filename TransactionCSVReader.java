package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TransactionCSVReader implements DataReader {

    @Override
    public List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader br;
            if (filePath.startsWith("http://") || filePath.startsWith("https://")) {
                URL url = new URL(filePath);
                br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            } else {
                br = new BufferedReader(new InputStreamReader(new java.io.FileInputStream(filePath), StandardCharsets.UTF_8));
            }

            try (br) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty() || line.startsWith("Дата") || line.startsWith("Date")) {
                        continue;
                    }
                    String[] values = line.split(",");
                    if (values.length >= 3) {
                        String date = values[0].trim();
                        double amount = Double.parseDouble(values[1].trim());
                        String description = values[2].trim();

                        transactions.add(new Transaction(date, amount, description));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Помилка при читанні CSV даних: " + e.getMessage());
        }

        return transactions;
    }
}