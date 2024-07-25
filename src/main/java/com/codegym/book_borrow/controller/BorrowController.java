package com.codegym.book_borrow.controller;



import com.codegym.book_borrow.model.Borrow;
import com.codegym.book_borrow.service.book.IBookService;
import com.codegym.book_borrow.service.borrow.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("borrow")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IBookService bookService;


    @GetMapping("/{bookId}/confirm")
    public String confirm(@PathVariable ("bookId") Long id, Model model) {
        Borrow borrow = new Borrow();
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("borrow", borrow);
        return "confirm_borrow";
    }

    @PostMapping("/{bookId}")
    public String borrowBook(@PathVariable("bookId") Long bookId, @RequestParam("bookRenter") String bookRenter, Model model) {
        Borrow borrow = borrowService.borrowBook(bookId, bookRenter);
        if (borrow == null) {
            return "error";
        }
        model.addAttribute("borrowCode", borrow.getCode());
        return "borrow_success";
    }

    @GetMapping("/return")
    public String showFormReturnBook() {
        return "form_return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("code") String code) {
        boolean success = borrowService.returnBook(code);
        if (!success) {
            return "error";
        }
        return "return_success";
    }
}
