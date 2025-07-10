package org.gfg.DigitalLibrary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int findBookById(String id){
        int bookId = Integer.parseInt(id);
        String query = "SELECT BOOK_ID FROM book where BOOK_ID=?";
        int row = jdbcTemplate.queryForObject(query, Integer.class,bookId);
        return row;
    }

    public int createBookInDatabase(String bookId, String bookName, String bookType, String authorId){
        int bookInt = Integer.parseInt(bookId);
        String query = "INSERT INTO book (BOOK_ID, BOOK_NAME, BOOK_TYPE, AUTHOR_ID) VALUES (?,?,?,?)";
        int row = jdbcTemplate.update(query,bookInt,bookName,bookType, authorId);
        return row;
    }
}
