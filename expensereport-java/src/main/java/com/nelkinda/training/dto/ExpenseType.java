package com.nelkinda.training.dto;

public enum ExpenseType {
    DINNER(ExpenseCategory.MEAL, "Dinner", 5000),
    BREAKFAST(ExpenseCategory.MEAL, "Breakfast", 1000),
    CAR_RENTAL(ExpenseCategory.OTHER, "Car Rental", Double.POSITIVE_INFINITY);


    private final ExpenseCategory category;
    private final String name;

    //overExpensesMarker could be extracted to separate
    // overExpensesMarker mapping
    private final Double overExpensesMarker;

    public ExpenseCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Double getOverExpensesMarker() {
        return overExpensesMarker;
    }


    ExpenseType(ExpenseCategory category, String name, double overExpensesMarker) {
        this.category = category;
        this.name = name;
        this.overExpensesMarker = overExpensesMarker;
    }
}
