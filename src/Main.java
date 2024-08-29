import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Expenses by Category");
            System.out.println("4. Generate Monthly Report");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    manager.addExpense(category, amount, LocalDate.now(), description);
                    break;
                case 2:
                    List<Expense> allExpenses = manager.getExpenses();
                    for (Expense expense : allExpenses) {
                        System.out.println(expense);
                    }
                    break;
                case 3:
                    System.out.print("Enter category: ");
                    String cat = scanner.nextLine();
                    List<Expense> categorizedExpenses = manager.getExpensesByCategory(cat);
                    for (Expense expense : categorizedExpenses) {
                        System.out.println(expense);
                    }
                    break;
                case 4:
                    System.out.print("Enter month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    double total = manager.getTotalExpensesForMonth(month, year);
                    System.out.println("Total expenses for " + month + "/" + year + ": " + total);
                    break;
                case 5:
                    System.out.print("Enter expense index to delete: ");
                    int index = scanner.nextInt();
                    manager.deleteExpense(index);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
