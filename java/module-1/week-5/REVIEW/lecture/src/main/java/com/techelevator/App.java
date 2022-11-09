package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private final Scanner keyboard = new Scanner(System.in);

    // Instead of four separate Lists for title, author, year and price,
    //      we need only one List: to hold objects of type Book.
    // This variable is non-static, meaning every instance of type "App" has its own separate List of Books.
    private List<Book> books = new ArrayList<>();

    // Every Java application begins with a main method, which is static, because we have no objects yet,
    //      and a static method does not require any object to call it.
    // Static methods are called using the syntax ClassName.staticMethodName()
    // In this case, Java itself will call App.main(args) to begin executing the method below.
    public static void main(String[] args) {
        // The first thing we do is create an object.
        // An object is always created by calling its constructor.
        App app = new App();
        // Once we have an object, we can call its non-static methods.
        app.loadData();
        app.run();
    }

    /** Split each String from the dataset into a new Book, and populate the instance variable named "books". */
    private void loadData() {
        String[] library = Dataset.load();
        for (String book : library) {
            String[] bookFields = book.split(FIELD_DELIMITER);
            Book newBook = new Book(
                    bookFields[0],
                    bookFields[1],
                    Integer.parseInt(bookFields[2])
            );
            // The Book constructor does not accept a price variable,
            //      so instead we set the price using a setter method.
            //      The setter will replace the default book price (which happens to be Book.MIN_PRICE).
            BigDecimal bookPrice = new BigDecimal(bookFields[3]);
            newBook.setPrice(bookPrice);
            books.add(newBook);
        }
    }

    /** This simplified App can only filter titles. */
    private void run() {
        String filterTitle = promptForString("Enter title: ");
        List<Book> matchingBooks = filterByTitle(filterTitle);
        displaySearchResults(matchingBooks);
    }

    private void displaySearchResults(List<Book> matchingBooks) {
        for (Book matchingBook : matchingBooks) {
            // Every object can choose how it should be printed by returning a String from its toString() method.
            // We'll learn more about this kind of interaction in Week 6.
            System.out.println(matchingBook);
        }
    }

    // Note that we don't need any index numbers here, because all fields of a given Book are encapsulated together.
    //      So every Book object knows its title, author, etc. without index look-ups.
    //      Since we don't need indexes, we can use the simpler "for-each" method, instead of the complex "for" method.
    private List<Book> filterByTitle(String filterTitle) {
        List<Book> output = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
                output.add(book);
            }
        }
        return output;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }
}
