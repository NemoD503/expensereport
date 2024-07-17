package com.nelkinda.training;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import com.nelkinda.training.dto.Expense;
import com.nelkinda.training.dto.ExpenseCategory;

public class ExpenseReport {
    private final Clock clock;

    public ExpenseReport(Clock clock) {
        this.clock = clock;
    }

    /**
     * @param List of person's expenses
     * @return String representation of the report
     */
    public String printReport(List<Expense> expenses) {
        int total = 0;
        int mealExpenses = 0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Expenses %s\n", LocalDateTime.now(clock)));

        for (Expense expense : expenses) {
            total += expense.getAmount();
            if (expense.getType().getCategory() == ExpenseCategory.MEAL) {
                mealExpenses += expense.getAmount();
            }
            sb.append(String.format(
                    "%s\t%d\t%s\n",
                    expense.getType().getName(), expense.getAmount(),
                    expense.getAmount() > expense.getType().getOverExpensesMarker() ? "X" : " "
            ));
        }
        sb.append(String.format("Meal expenses: %d\n", mealExpenses));
        sb.append(String.format("Total expenses: %d\n", total));

        return sb.toString();
    }

}
