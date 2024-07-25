package com.codegym.book_borrow.service.book;

import com.codegym.book_borrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    void deleteById(Long id);

    Book findById(Long id);
}
