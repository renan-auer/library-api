package com.softdesign.libraryapi.services.interfaces;

import com.softdesign.libraryapi.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IListBookService {

    Page<BookDTO> list(Pageable page, String name, String author);

}
