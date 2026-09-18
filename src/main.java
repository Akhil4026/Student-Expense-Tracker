import service.ExpenseManager;
import ui.ExpenseMenu;
import util.FileHandler;

public class Main {

    public static void main(String[] args) {

        ExpenseManager manager = new ExpenseManager();

        manager.setExpenses(FileHandler.loadExpenses());

        ExpenseMenu menu = new ExpenseMenu(manager);

        menu.start();
    }
}
