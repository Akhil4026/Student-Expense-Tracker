package util;

import model.Expense;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "data/expenses.csv";

    public static void saveExpenses(ArrayList<Expense> expenses) {

        try {

            File directory = new File("data");

            if (!directory.exists()) {
                directory.mkdir();
            }

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Expense expense : expenses) {

                writer.write(
                        expense.getId() + "," +
                        expense.getCategory() + "," +
                        expense.getAmount() + "," +
                        expense.getDescription() + "," +
                        expense.getDate() + "\n"
                );
            }

            writer.close();

            System.out.println("Expenses saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving expenses.");
        }
    }

    public static ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return expenses;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String category = data[1];
                double amount = Double.parseDouble(data[2]);
                String description = data[3];
                String date = data[4];

                Expense expense = new Expense(
                        id,
                        category,
                        amount,
                        description,
                        date
                );

                expenses.add(expense);
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error loading expenses.");
        }

        return expenses;
    }
}
