package org.gfg.DigitalLibrary.controller;

import org.gfg.DigitalLibrary.model.Book;
import org.gfg.DigitalLibrary.request.CreateBookRequest;
import org.gfg.DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest createBookRequest){
        Book book = bookService.createBook(createBookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
