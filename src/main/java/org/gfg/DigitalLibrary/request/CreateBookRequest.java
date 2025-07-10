package org.gfg.DigitalLibrary.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.DigitalLibrary.model.Author;
import org.gfg.DigitalLibrary.model.Book;
import org.gfg.DigitalLibrary.model.BookType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateBookRequest {

    String bookId;
    String bookName;
    BookType bookType;
    String authorName;
    String authorEmail;
    String authorNumber;

    public static Book toBook(CreateBookRequest request){
        Book book = Book.builder().bookName(request.getBookName())
                .bookId(Integer.parseInt(request.getBookId()))
                .bookType(request.getBookType()).build();
        return book;
    }

    public static Author toAuthor(CreateBookRequest request){
        Author author = Author.builder().email(request.getAuthorEmail())
                .name(request.getAuthorName()).phoneNo(request.getAuthorNumber()).build();
        return author;
    }




}
