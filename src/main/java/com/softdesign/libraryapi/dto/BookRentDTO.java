package com.softdesign.libraryapi.dto;

import com.softdesign.libraryapi.domain.BookRent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookRentDTO {

    private String id;

    private String username;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String bookIid;

    public BookRent toEntity() {
        BookRent bookRent = new BookRent();
        bookRent.setId(this.id);
        bookRent.setStartDate(this.startDate);
        bookRent.setEndDate(this.endDate);
        bookRent.setUsername(this.username);
        return bookRent;
    }

    public static BookRentDTO fromEntity(BookRent bookRent) {
        BookRentDTO bookRentDTO = new BookRentDTO();
        bookRentDTO.setId(bookRent.getId());
        bookRentDTO.setBookIid(bookRent.getBook().getId());
        bookRentDTO.setUsername(bookRent.getUsername());
        bookRentDTO.setStartDate(bookRent.getStartDate());
        bookRentDTO.setEndDate(bookRent.getEndDate());
        return bookRentDTO;
    }

}
