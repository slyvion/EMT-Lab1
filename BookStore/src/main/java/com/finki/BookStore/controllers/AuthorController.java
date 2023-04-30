package com.finki.BookStore.controllers;

import com.finki.BookStore.models.dto.AuthorDto;
import com.finki.BookStore.models.entities.Author;
import com.finki.BookStore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/createOrUpdate")
    public Author createOrUpdate(@RequestBody AuthorDto authorDto) {
        return authorService.saveOrUpdate(authorDto);
    }

    @GetMapping("")
    public List<Author> getallAuthors() { return authorService.getAll(); }

    }
