
package com.softdesign.libraryapi.services.bookrental;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.domain.BookRent;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.dto.BookRentDTO;
import com.softdesign.libraryapi.dto.CreateBookRentDTO;
import com.softdesign.libraryapi.repository.BookRentRepository;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.book.GetBookByIdService;
import com.softdesign.libraryapi.services.interfaces.IRentBookService;
import com.softdesign.libraryapi.services.interfaces.ISaveBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RentBookService implements IRentBookService {

    private final GetBookByIdService getBookByIdService;
    private final BookRentRepository bookRentRepository;

    public RentBookService(BookRentRepository bookRentRepository,
                           GetBookByIdService getBookByIdService) {
        this.bookRentRepository = bookRentRepository;
        this.getBookByIdService = getBookByIdService;
    }

    @Override
    public BookRentDTO rent(CreateBookRentDTO createBookRentDTO) throws Exception {
        Optional<BookRent> bookAlreadyRented = this.bookRentRepository.findByBookIdAndEndDate(createBookRentDTO.getBookId(), null);

        if (bookAlreadyRented.isPresent()) {
            throw new Exception("Livro já está alugado!");
        }

        BookDTO bookToRent = this.getBookByIdService.get(createBookRentDTO.getBookId());

        if (bookToRent == null) {
            throw new Exception("Livro não encontrado!");
        }

        BookRent bookRent = new BookRent();
        bookRent.setUsername(createBookRentDTO.getUsername());
        bookRent.setBook(bookToRent.toEntity());
        bookRent.setStartDate(LocalDateTime.now());
        bookRent.setEndDate(null);
        BookRent bookRentResponse = this.bookRentRepository.save(bookRent);
        return BookRentDTO.fromEntity(bookRentResponse);
    }
}
