package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Book implements CatalogItem {
    private String title;
    private String author;
    private LocalDate publishDate;
    private String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase().contains(searchStr.toLowerCase());
    }// kind of simplified the if and else statement

    @Override
    public boolean matchesCreator(String searchStr) {
        if (author.toLowerCase().contains(searchStr.toLowerCase())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if (publishDate.getYear() == searchYear) {
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(this + " ," + LocalDate.now() + " , " + LocalTime.now(),
                    "src/main/resources/logs/books", true);
        } catch (FileStorageException | FileNotFoundException e) {
            e.printStackTrace();
        }
// date and time we have to take the current time or date, so we can use a new date or we can use LocalDate.now
    }
}