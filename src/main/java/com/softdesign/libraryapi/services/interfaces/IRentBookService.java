package com.softdesign.libraryapi.services.interfaces;


import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.dto.BookRentDTO;
import com.softdesign.libraryapi.dto.CreateBookRentDTO;

public interface IRentBookService {

    BookRentDTO rent(CreateBookRentDTO createBookRentDTO) throws Exception;

}
