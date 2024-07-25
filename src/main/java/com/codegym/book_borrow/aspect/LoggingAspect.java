package com.codegym.book_borrow.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* com.codegym.book_borrow.service.borrow.BorrowService.borrowBook(..))")
    public void logBorrowAction() {
        logger.info("Một cuốn sách đã được mượn");
    }

    @After("execution(* com.codegym.book_borrow.service.borrow.BorrowService.returnBook(..))")
    public void logReturnAction() {
        logger.info("Một cuốn sách đã được trả");
    }

    @Before("execution(* com.codegym.book_borrow.controller..*(..))")
    public void logVisitor() {
        logger.info("Một người dùng đã truy cập thư viện.");
    }
}