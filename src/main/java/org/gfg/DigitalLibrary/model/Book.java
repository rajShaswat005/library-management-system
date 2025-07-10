package org.gfg.DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private int bookId;
    private String bookName;
    private Author authorName;
    BookType bookType;
    private double price;
}
