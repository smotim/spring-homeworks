package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PopularBooksController
{
    private final BookService bookService;

    @Autowired
    public PopularBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("popular")
    public List<Book> recommendedBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/books/popular")
    public String main()
    {
        return "books/popular";
    }
}
