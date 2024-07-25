package com.codegym.book_borrow.repository;



import com.codegym.book_borrow.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBorrowRepo extends JpaRepository<Borrow, Long> {
    Borrow findByCode(String code);
}
