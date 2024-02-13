
package com.softdesign.libraryapi.services.book;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.interfaces.ISaveBookService;
import org.springframework.stereotype.Service;

@Service
public class SaveBookService implements ISaveBookService {

    private final BookRepository bookRepository;

    public SaveBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = this.bookRepository.save(bookDTO.toEntity());
        return BookDTO.fromEntity(book);
    }
}
