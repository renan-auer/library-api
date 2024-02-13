
package com.softdesign.libraryapi.services.bookrental;

import com.softdesign.libraryapi.dto.BookRentDTO;
import com.softdesign.libraryapi.repository.BookRentRepository;
import com.softdesign.libraryapi.services.interfaces.IListBookRentalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListBookRentService implements IListBookRentalService {

    private final BookRentRepository bookRentRepository;

    public ListBookRentService(BookRentRepository bookRentRepository) {
        this.bookRentRepository = bookRentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookRentDTO> list(Pageable page) {
        return this.bookRentRepository.findAll(page).map(BookRentDTO::fromEntity);
    }
}
