package com.softdesign.libraryapi.services.book;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.interfaces.ISaveBookService;
import com.softdesign.libraryapi.services.interfaces.IUpdateBookService;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookService implements IUpdateBookService {

    private final BookRepository bookRepository;

    public UpdateBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDTO update(String id, BookDTO bookDTO) {
        Book book = bookDTO.toEntity();
        book.setId(id);
        Book bookUpdated = this.bookRepository.save(book);
        return BookDTO.fromEntity(bookUpdated);
    }
}
