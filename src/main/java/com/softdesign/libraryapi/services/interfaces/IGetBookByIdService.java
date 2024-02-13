package com.softdesign.libraryapi.services.interfaces;


import com.softdesign.libraryapi.dto.BookDTO;

public interface IGetBookByIdService {

    BookDTO get(String id);

}
