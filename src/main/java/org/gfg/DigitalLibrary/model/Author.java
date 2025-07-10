package org.gfg.DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Author {

    private int authorId;
    private String name;
    private String email;
    private String phoneNo;
    private List<Book> bookList;
}
