package com.softdesign.libraryapi.dto;

import com.softdesign.libraryapi.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String id;

    private String name;

    private String author;

    private String publishingCompany;

    public Book toEntity() {
        Book book = new Book();
        book.setId(this.id);
        book.setName(this.name);
        book.setPublishingCompany(this.publishingCompany);
        return book;
    }

    public static BookDTO fromEntity(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(bookDTO.name);
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublishingCompany(book.getPublishingCompany());
        return bookDTO;
    }
}
