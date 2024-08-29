import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount, LocalDate date, String description) {
        Expense expense = new Expense(category, amount, date, description);
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> categorizedExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                categorizedExpenses.add(expense);
            }
        }
        return categorizedExpenses;
    }

    public double getTotalExpensesForMonth(int month, int year) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getDate().getMonthValue() == month && expense.getDate().getYear() == year) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public void deleteExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
        }
    }
}
