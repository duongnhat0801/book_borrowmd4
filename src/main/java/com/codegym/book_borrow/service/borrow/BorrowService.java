package com.codegym.book_borrow.service.borrow;

import com.codegym.book_borrow.model.Book;
import com.codegym.book_borrow.model.Borrow;
import com.codegym.book_borrow.repository.IBookRepo;
import com.codegym.book_borrow.repository.IBorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepo borrowRepo;

    @Autowired
    private IBookRepo bookRepo;

    public Borrow borrowBook(Long bookId, String bookRenter) {
        Book book = bookRepo.findById(bookId).orElse(null);
        if (book == null || book.getQuantity() <= 0) {
            return null;
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBookRenter(bookRenter);
        borrow.setCode(generateBorrowCode());
        borrowRepo.save(borrow);

        return borrow;
    }

    public boolean returnBook(String code) {
        Borrow borrow = borrowRepo.findByCode(code);
        if (borrow == null) {
            return false;
        }

        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);

        borrowRepo.delete(borrow);
        return true;
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepo.findAll();
    }

    private String generateBorrowCode() {
        Random random = new Random();
        return String.format("MS-%05d", random.nextInt(100000));
    }
}
