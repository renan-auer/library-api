package com.softdesign.libraryapi.services.interfaces;

import com.softdesign.libraryapi.dto.BookRentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IListBookRentalService {

    Page<BookRentDTO> list(Pageable page);

}
