package com.finki.BookStore.services;

import com.finki.BookStore.exceptions.NotFoundException;
import com.finki.BookStore.models.constants.Category;
import com.finki.BookStore.models.dto.AuthorDto;
import com.finki.BookStore.models.dto.BookDto;
import com.finki.BookStore.models.entities.Author;
import com.finki.BookStore.models.entities.Book;
import com.finki.BookStore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CountryService countryService;
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author saveOrUpdate(AuthorDto authorDto) {
        Author author = Author.builder()
                .id(authorDto.getId())
                .name(authorDto.getName())
                .surname(authorDto.getSurname())
                .country(countryService.getById(authorDto.getCountryId()))
                .build();

        return save(author);
    }
    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "Author"));
    }
}
