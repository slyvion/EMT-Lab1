package com.finki.BookStore.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Integer availableCopies;
}
