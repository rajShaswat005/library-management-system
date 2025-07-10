package org.gfg.DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    private int id;
    private int studentId;
    private String name;
    private String email;
    private String phoneNo;
    List<Book> books;
    Address address;
    StudentType studentType;
    Date createdOn;
    Date updatedOn;



}
