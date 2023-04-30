package com.finki.BookStore.services;

import com.finki.BookStore.exceptions.NotEnoughCopies;
import com.finki.BookStore.exceptions.NotFoundException;
import com.finki.BookStore.models.constants.Category;
import com.finki.BookStore.models.dto.BookDto;
import com.finki.BookStore.models.entities.Book;
import com.finki.BookStore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Book saveOrUpdate(BookDto bookDto) {
        Book book = Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .category(Category.valueOf(bookDto.getCategory()))
                .author(authorService.getById(bookDto.getAuthorId()))
                .availableCopies(bookDto.getAvailableCopies())
                .build();

        return bookRepository.save(book);
    }
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Book"));
    }
    public Book deleteById(Long bookId) {
        Book book = getById(bookId);
        bookRepository.deleteById(bookId);
        return book;
    }

    public Book rentBook(Long bookId) {
        Book book = getById(bookId);

        if (book.getAvailableCopies() <= 0) {
            throw new NotEnoughCopies();
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
