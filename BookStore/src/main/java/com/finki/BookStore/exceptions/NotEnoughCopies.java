package com.finki.BookStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughCopies extends RuntimeException{
    public NotEnoughCopies() {
        super("There aren't enough copies of this book.");
    }
}
