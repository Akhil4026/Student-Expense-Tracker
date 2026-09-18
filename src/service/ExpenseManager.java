package service;

import model.Expense;
import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses = new ArrayList<>();

    private int nextId = 1;

    public void addExpense(String category, double amount,
                            String description, String date) {

        Expense expense = new Expense(
                nextId,
                category,
                amount,
                description,
                date
        );

        expenses.add(expense);
        nextId++;

        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void searchByCategory(String category) {

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                System.out.println(expense);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                expenses.remove(expense);
                System.out.println("Expense deleted successfully!");
                return;
            }
        }

        System.out.println("Expense ID not found.");
    }

    public double getTotalExpenses() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;

        nextId = 1;

        for (Expense expense : expenses) {
            if (expense.getId() >= nextId) {
                nextId = expense.getId() + 1;
            }
        }
    }
}
