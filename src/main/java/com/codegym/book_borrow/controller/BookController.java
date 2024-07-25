package com.codegym.book_borrow.controller;


import com.codegym.book_borrow.model.Book;
import com.codegym.book_borrow.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Book> books = bookService.findAll(PageRequest.of(page, 12));
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping("/{id}/detail")
    public String detail (@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

}
