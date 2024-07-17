package com.nelkinda.training;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import com.nelkinda.training.dto.Expense;
import com.nelkinda.training.dto.ExpenseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@SuppressWarnings("java:S2187")
public class CucumberTest {


    @Test
    void name() {
        String expected = """
                Expenses 2024-07-16T15:28:32
                Dinner	5200	X
                Dinner	1000\t\s
                Car Rental	2000\t\s
                Breakfast	2000	X
                Meal expenses: 8200
                Total expenses: 10200
                """;

        ExpenseReport report = new ExpenseReport(Clock.fixed(Instant.ofEpochSecond(1721136512L), ZoneId.of("Europe" +
                "/Paris")));
        var testData = List.of(
                new Expense(ExpenseType.DINNER, 5200),
                new Expense(ExpenseType.DINNER, 1000),
                new Expense(ExpenseType.CAR_RENTAL, 2000),
                new Expense(ExpenseType.BREAKFAST, 2000)
        );
        String result = report.printReport(testData);

        Assertions.assertEquals(expected, result);
    }
}
