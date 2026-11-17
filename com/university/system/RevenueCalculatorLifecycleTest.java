package com.university.system;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.*;

// Слайд 23: Власне розширення
class RevenueCalculatorExtension implements BeforeEachCallback, AfterEachCallback {
    private final RevenueCalculator calculator;

    RevenueCalculatorExtension(RevenueCalculator calculator) {
        this.calculator = calculator;
    }

    RevenueCalculator calculator() {
        return calculator;
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        calculator.reset();
        calculator.start();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        calculator.stop();
    }
}

public class RevenueCalculatorLifecycleTest {
    static RevenueCalculator staticCalculator;

    // Слайд 22: @BeforeAll та @BeforeEach
    @BeforeAll
    static void init() {
        staticCalculator = new RevenueCalculator();
    }

    @BeforeEach
    void resetCalculator() {
        staticCalculator.reset();
    }

    @Test
    void testCalculateRevenueLifecycle() {
        TicketRevenue ticket = new TicketRevenue(10, 20);
        assertEquals(200, staticCalculator.calculate(ticket));
    }

    // Слайд 23: @RegisterExtension
    @RegisterExtension
    RevenueCalculatorExtension ext =
            new RevenueCalculatorExtension(new RevenueCalculator());

    @Test
    void testCalculateRevenueWithExtension() {
        TicketRevenue ticket = new TicketRevenue(15, 30);
        assertEquals(450, ext.calculator().calculate(ticket));
    }

    @Test
    void testInvalidRevenue() {
        assertThrows(IllegalArgumentException.class,
                () -> ext.calculator().calculate(null));
    }

    // Слайд 24: Лямбда-вираз у assertThrows
    @Test
    public void nullThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            staticCalculator.calculate(null);
        });
    }

    @AfterAll
    static void cleanup() {
        staticCalculator = null;
    }
}