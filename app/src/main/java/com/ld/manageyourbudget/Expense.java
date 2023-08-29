package com.ld.manageyourbudget;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Expense {
    private final String name;
    private final String category;
    private final LocalDate purchaseDate;
    private final BigDecimal totalPrice;

    public Expense(String name, String category, LocalDate purchaseDate, BigDecimal totalPrice) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
