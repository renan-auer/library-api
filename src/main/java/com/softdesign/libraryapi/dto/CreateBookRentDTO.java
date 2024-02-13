package com.softdesign.libraryapi.dto;

import com.softdesign.libraryapi.domain.BookRent;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateBookRentDTO {

    private String username;
    private String bookIid;

}
