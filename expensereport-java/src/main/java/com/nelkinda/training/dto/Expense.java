package com.nelkinda.training.dto;

//todo could be a record in modern java
public class Expense {
    private final ExpenseType type;

    //cents
    private final int amount;

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Expense expense)) {
            return false;
        }

        if (amount != expense.amount) {
            return false;
        }
        return type == expense.type;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }
}
