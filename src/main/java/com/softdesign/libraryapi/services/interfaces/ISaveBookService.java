package com.softdesign.libraryapi.services.interfaces;


import com.softdesign.libraryapi.dto.BookDTO;

public interface ISaveBookService {

    BookDTO save(BookDTO bookDTO);

}
