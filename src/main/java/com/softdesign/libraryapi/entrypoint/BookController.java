package com.softdesign.libraryapi.entrypoint;

import com.softdesign.libraryapi.dto.ApiResponse;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.services.interfaces.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private IListBookService listBookService;
    private IDeleteBookService deleteBookService;
    private ISaveBookService saveBookService;
    private IUpdateBookService updateBookService;
    private IGetBookByIdService getBookByIdService;

    public BookController(
            IListBookService listBookService,
            IDeleteBookService deleteBookService,
            ISaveBookService saveBookService,
            IUpdateBookService updateBookService,
            IGetBookByIdService getBookByIdService
    ) {
        this.listBookService = listBookService;
        this.deleteBookService = deleteBookService;
        this.saveBookService = saveBookService;
        this.updateBookService = updateBookService;
        this.getBookByIdService = getBookByIdService;
    }

    @ApiOperation(value = "Retorna uma lista de livros")
    @GetMapping
    public ResponseEntity<Page<BookDTO>> list(@RequestParam(required = false) String name, @RequestParam(required = false) String author, Pageable page) {
        Page<BookDTO> books = this.listBookService.list(page, name, author);
        return ResponseEntity.ok(books);
    }

    @ApiOperation(value = "Retorna livro por ID")
    @GetMapping(value = "{id}", produces="application/json")
    public ResponseEntity<ApiResponse<BookDTO>> getById(@PathVariable String id) {
        ApiResponse<BookDTO> response = new ApiResponse<>();
        try{
            response.setData(this.getBookByIdService.get(id));
        } catch (Exception e) {
            response.setError(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Salva um livro")
    @PostMapping
    public ResponseEntity<BookDTO> save(@Validated @RequestBody BookDTO book) {
        BookDTO bookDTO = this.saveBookService.save(book);
        return ResponseEntity.ok(bookDTO);
    }

    @ApiOperation(value = "Altera um livro")
    @PutMapping(value = "{id}", produces="application/json")
    public ResponseEntity<BookDTO> update(@PathVariable String id, @Validated @RequestBody BookDTO book) {
        BookDTO bookDTO = this.updateBookService.update(id, book);
        return ResponseEntity.ok(bookDTO);
    }

    @ApiOperation(value = "Deleta um livro")
    @DeleteMapping(value = "{id}", produces="application/json")
    public ResponseEntity<BookDTO> delete(@PathVariable String id) {
        this.deleteBookService.delete(id);
        return ResponseEntity.ok().build();
    }

}
