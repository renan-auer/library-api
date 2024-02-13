package com.softdesign.libraryapi.services.interfaces;


import com.softdesign.libraryapi.dto.BookRentDTO;

public interface IReturnBookService {

    BookRentDTO returnBook(String bookRentId)  throws Exception ;

}
