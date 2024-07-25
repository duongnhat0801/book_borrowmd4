package com.codegym.book_borrow.dto;

import com.codegym.book_borrow.model.Book;

public interface IBorrowDto {
    Long getId();
    String getCode();
    String getBookRenter();
    Book getBook();
}
