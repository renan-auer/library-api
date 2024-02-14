package com.softdesign.libraryapi.entrypoint;

import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.book.DeleteBookService;
import com.softdesign.libraryapi.services.book.GetBookByIdService;
import com.softdesign.libraryapi.services.book.ListBookService;
import com.softdesign.libraryapi.services.book.SaveBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class BookControllerTest {

    @Mock
    private SaveBookService saveBookService;

    @Mock
    private ListBookService listBookService;

    @Mock
    private GetBookByIdService getBookByIdService;

    @Mock
    private DeleteBookService deleteBookService;

    @InjectMocks
    private BookController controller;

    @Test
    void execute_shouldCallListBookService() throws Exception {
        Pageable pageable = PageRequest.of(1, 2);
        List<BookDTO> books = Arrays.asList(new BookDTO());

        when(listBookService.list(pageable, "name", "author")).thenReturn( new PageImpl(books));

        ResponseEntity<Page<BookDTO>> response = controller.list("name", "author", pageable);


        verify(listBookService, times(1)).list(any(), any(), any());
        assertEquals(1, response.getBody().getTotalElements());
    }

    @Test
    void execute_shouldCallSaveBookService() throws Exception {
        BookDTO bookDTO = new BookDTO();
        when(saveBookService.save(bookDTO)).thenReturn(bookDTO);
        controller.save(bookDTO);
        verify(saveBookService, times(1)).save(any());
    }

    @Test
    void execute_shouldCallGetBookByIdService() throws Exception {
        String bookId = "1";
        BookDTO bookDTO = new BookDTO();
        when(getBookByIdService.get(bookId)).thenReturn(bookDTO);
        controller.getById(bookId);
        verify(getBookByIdService, times(1)).get(any());
    }
    @Test
    void execute_shouldCallDeleteBookService() throws Exception {
        controller.delete("id");
        verify(deleteBookService, times(1)).delete(any());
    }



}
