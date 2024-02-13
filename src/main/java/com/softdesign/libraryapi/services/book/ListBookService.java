
package com.softdesign.libraryapi.services.book;

import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.interfaces.IListBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListBookService implements IListBookService {

    private final BookRepository bookRepository;

    public ListBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookDTO> list(Pageable page) {
        return this.bookRepository.findAll(page).map(BookDTO::fromEntity);
    }
}
