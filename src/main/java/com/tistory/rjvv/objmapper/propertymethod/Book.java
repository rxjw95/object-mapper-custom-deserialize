package com.tistory.rjvv.objmapper.propertymethod;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Book {

    private String isbn;
    private String name;

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }
}
