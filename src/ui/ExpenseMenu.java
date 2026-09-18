package ui;

import service.ExpenseManager;
import util.FileHandler;

import java.util.Scanner;

public class ExpenseMenu {

    private ExpenseManager manager;
    private Scanner scanner;

    public ExpenseMenu(ExpenseManager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("   STUDENT EXPENSE TRACKER");
            System.out.println("==============================");

            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Delete Expense");
            System.out.println("5. View Total Spending");
            System.out.println("6. Save Expenses");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    manager.searchByCategory(category);
                    break;

                case 4:
                    System.out.print("Enter expense ID: ");
                    int id = scanner.nextInt();
                    manager.deleteExpense(id);
                    break;

                case 5:
                    System.out.println(
                            "Total Spending: ₹" +
                            manager.getTotalExpenses()
                    );
                    break;

                case 6:
                    FileHandler.saveExpenses(manager.getExpenses());
                    break;

                case 7:
                    FileHandler.saveExpenses(manager.getExpenses());
                    System.out.println("Thank you for using the application.");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 7);
    }

    private void addExpense() {

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        manager.addExpense(category, amount, description, date);
    }
}
