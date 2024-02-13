
package com.softdesign.libraryapi.services.book;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.interfaces.IGetBookByIdService;
import com.softdesign.libraryapi.services.interfaces.IListBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GetBookByIdService implements IGetBookByIdService {

    private final BookRepository bookRepository;

    public GetBookByIdService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public BookDTO get(String id) {
        Optional<Book> book = this.bookRepository.findById(id);
        return book.map(BookDTO::fromEntity).orElse(null);
    }
}
