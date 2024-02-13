package com.softdesign.libraryapi.entrypoint;

import com.softdesign.libraryapi.dto.ApiResponse;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.dto.BookRentDTO;
import com.softdesign.libraryapi.dto.CreateBookRentDTO;
import com.softdesign.libraryapi.services.interfaces.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book-rent")
public class BookRentController {

    private IListBookRentalService listBookRentalService;
    private IReturnBookService returnBookService;
    private IRentBookService rentBookService;

    public BookRentController(
            IListBookRentalService listBookRentalService,
            IReturnBookService returnBookService,
            IRentBookService rentBookService
    ) {
        this.listBookRentalService = listBookRentalService;
        this.returnBookService = returnBookService;
        this.rentBookService = rentBookService;
    }

    @ApiOperation(value = "Retorna uma lista de alugueis de livros")
    @GetMapping
    public ResponseEntity<Page<BookRentDTO>> list(Pageable page) {
        Page<BookRentDTO> bookRentals = this.listBookRentalService.list(page);
        return ResponseEntity.ok(bookRentals);
    }


    @ApiOperation(value = "Realiza o aluguel de um livro")
    @PostMapping(value = "rent")
    public ResponseEntity<BookRentDTO> rent(@Validated @RequestBody CreateBookRentDTO createBookRentDTO) throws Exception {
        BookRentDTO bookRentResponse = this.rentBookService.rent(createBookRentDTO);
        return ResponseEntity.ok(bookRentResponse);
    }

    @ApiOperation(value = "Realiza a devolução de um livro")
    @PostMapping(value = "return/{id}")
    public ResponseEntity<BookRentDTO> returnBook(@PathVariable String id) throws Exception {
        BookRentDTO bookRentResponse = this.returnBookService.returnBook(id);
        return ResponseEntity.ok(bookRentResponse);
    }


}
