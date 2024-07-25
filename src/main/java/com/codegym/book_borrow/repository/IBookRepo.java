package com.codegym.book_borrow.repository;

import com.codegym.book_borrow.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book, Long> {
}
