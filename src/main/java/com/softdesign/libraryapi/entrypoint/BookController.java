package com.softdesign.libraryapi.entrypoint;

import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.services.interfaces.IListBookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private IListBookService listBookService;

    public BookController(
            IListBookService listBookService
    ) {
        this.listBookService = listBookService;
    }

    @ApiOperation(value = "Retorna uma lista de livros")
    @GetMapping
    public ResponseEntity<Page<BookDTO>> list(Pageable page) {
        Page<BookDTO> pautas = this.listBookService.list(page);
        return ResponseEntity.ok(pautas);
    }

}
