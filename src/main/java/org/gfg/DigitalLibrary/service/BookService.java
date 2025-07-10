package org.gfg.DigitalLibrary.service;

import org.gfg.DigitalLibrary.Exception.BookAlreadyPresent;
import org.gfg.DigitalLibrary.model.Author;
import org.gfg.DigitalLibrary.model.Book;
import org.gfg.DigitalLibrary.repository.AuthorDAO;
import org.gfg.DigitalLibrary.repository.BookDAO;
import org.gfg.DigitalLibrary.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookDAO bookDAO;

    @Autowired
    AuthorDAO authorDAO;

    public Book createBook(CreateBookRequest createBookRequest){
        String bookId = createBookRequest.getBookId();
        String bookName = createBookRequest.getBookName();
        String bookType = createBookRequest.getBookType().toString();
        String authorEmail = createBookRequest.getAuthorEmail();

        Book bookResult = null;

        try {
            int status = bookDAO.findBookById(bookId);
            if (status > 0) {
                throw new BookAlreadyPresent("Book is Already present in the database");
            }

            int result = bookDAO.createBookInDatabase(bookId,bookName, bookType, authorEmail);
            if (result<=0){
                return null;
            }

            boolean isAuthorExist = false;

           try {
               Author authorExist = authorDAO.findAuthorById(authorEmail);
               isAuthorExist = true;
           }
           catch (Exception e){
                isAuthorExist = false;
           }

            if (isAuthorExist==true){
                return bookResult;
            }

            authorDAO.createAuthor(CreateBookRequest.toAuthor(createBookRequest));

        } catch (BookAlreadyPresent e) {
            throw new RuntimeException(e);
        }

        return bookResult;


    }
}
