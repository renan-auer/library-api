package com.softdesign.libraryapi.services.interfaces;


import com.softdesign.libraryapi.dto.BookDTO;

public interface IUpdateBookService {

    BookDTO update(String id, BookDTO pautaDTO);

}
