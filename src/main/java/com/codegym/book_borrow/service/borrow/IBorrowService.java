package com.codegym.book_borrow.service.borrow;

import com.codegym.book_borrow.model.Borrow;

import java.util.List;

public interface IBorrowService {
    Borrow borrowBook(Long bookId, String bookRenter);

    boolean returnBook(String code);

    List<Borrow> findAll();
}
