package com.codegym.book_borrow.service.book;

import com.codegym.book_borrow.model.Book;
import com.codegym.book_borrow.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo bookRepo;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
}
