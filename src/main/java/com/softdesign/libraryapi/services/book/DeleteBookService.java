package com.softdesign.libraryapi.services.book;

import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.interfaces.IDeleteBookService;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService implements IDeleteBookService {

    private final BookRepository bookRepository;

    public DeleteBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void delete(String id) {
        this.bookRepository.deleteById(id);
    }
}
