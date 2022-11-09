package com.techelevator;

import java.math.BigDecimal;

public class Book {
    public static final BigDecimal MIN_PRICE = BigDecimal.TEN;

    private String title;
    private String author;
    private int publishedYear;
    private BigDecimal price = MIN_PRICE;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        return title + ": " + author + ": " + publishedYear + ": " + price;
    }
}
