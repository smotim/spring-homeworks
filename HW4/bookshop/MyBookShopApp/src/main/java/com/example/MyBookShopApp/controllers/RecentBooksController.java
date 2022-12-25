package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class RecentBooksController
{
    private final BookService bookService;

    @Autowired
    public RecentBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recentBooks")
    public List<Book> recommendedBooks(){
        return bookService.getNewBooks();
    }

    @GetMapping("/books/recent")
    public String main()
    {
        return "books/recent";
    }
}
