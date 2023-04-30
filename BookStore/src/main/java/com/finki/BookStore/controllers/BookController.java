package com.finki.BookStore.controllers;

import com.finki.BookStore.models.dto.BookDto;
import com.finki.BookStore.models.entities.Book;
import com.finki.BookStore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/createOrUpdate")
    public Book createOrUpdate(@RequestBody BookDto bookDto) {
        return bookService.saveOrUpdate(bookDto);
    }

    @DeleteMapping("/delete/{bookId}")
    public Book deleteBook(@PathVariable Long bookId) {
        return bookService.deleteById(bookId);
    }

    @PostMapping("/rent/{bookId}")
    public Book rentBook(@PathVariable Long bookId) {
        return bookService.rentBook(bookId);
    }

    @GetMapping("")
    public List<Book> getAllBooks(){ return bookService.getAll();}

}
