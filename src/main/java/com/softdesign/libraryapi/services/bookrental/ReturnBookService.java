
package com.softdesign.libraryapi.services.bookrental;

import com.softdesign.libraryapi.domain.BookRent;
import com.softdesign.libraryapi.dto.BookRentDTO;
import com.softdesign.libraryapi.repository.BookRentRepository;
import com.softdesign.libraryapi.services.interfaces.IRentBookService;
import com.softdesign.libraryapi.services.interfaces.IReturnBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReturnBookService implements IReturnBookService {

    private final BookRentRepository bookRentRepository;

    public ReturnBookService(BookRentRepository bookRentRepository) {
        this.bookRentRepository = bookRentRepository;
    }

    @Override
    public BookRentDTO returnBook(String bookRentId) throws Exception {
        Optional<BookRent> bookRentOptional = this.bookRentRepository.findById(bookRentId);
        if(!bookRentOptional.isPresent()) {
            throw new Exception("Livro não encontrado!");
        }
        BookRent bookRent = bookRentOptional.get();
        bookRent.setEndDate(LocalDateTime.now());
        this.bookRentRepository.save(bookRent);
        return BookRentDTO.fromEntity(bookRent);
    }
}
