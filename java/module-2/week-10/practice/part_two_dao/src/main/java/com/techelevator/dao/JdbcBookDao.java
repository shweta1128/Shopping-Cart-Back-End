package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBook(int bookId) {
        Book book = new Book();
        String sqlForBookId = "SELECT book_id, book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date " +
                "FROM book " +
                "WHERE book_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForBookId, bookId);
        if (results.next()) {
            book = mapRowToBook(results);
        }
        return book;
    }

    @Override
    public Book updateRating(int bookId, BigDecimal newRating) {
        Book book = null;
        String sqlForBookId = "SELECT book_id, book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date " +
                "FROM book " +
                "WHERE book_id = ? ;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForBookId, bookId);
        while (results.next()){
            book = mapRowToBook(results);
        }
        book.setStarRating(newRating);
        String sqlToUpdateTheRatings = "UPDATE book SET star_rating = ? " +
                "WHERE book_id = ? ;";
        jdbcTemplate.update(sqlToUpdateTheRatings, book.getStarRating(),bookId);

      return book;
    }

    @Override
    public void deleteBook(int bookId) {
       try {
           String sqlToDeleteFromAuthor = "DELETE FROM book_author ba WHERE ba.book_id = ? ;";
           jdbcTemplate.update(sqlToDeleteFromAuthor, bookId);
           String sqlToDeleteTheBook = "DELETE FROM book WHERE book.book_id = ? ;";
           jdbcTemplate.update(sqlToDeleteTheBook, bookId);
       }
       catch(Exception e){
           System.out.println("Error");
       }
    }

    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();
        book.setBookId(results.getInt("book_id"));
        book.setBookTitle(results.getString("book_title"));
        book.setStarRating(results.getBigDecimal("star_rating"));
        book.setOutOfPrint(results.getBoolean("out_of_print"));
        book.setForewordBy((Integer) results.getObject("foreword_by"));
        book.setPublisherId(results.getInt("publisher_id"));
        if (results.getDate("published_date") != null) {
            book.setPublishedDate(results.getDate("published_date").toLocalDate());
        }
        return book;
    }
}
