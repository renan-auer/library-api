package com.softdesign.libraryapi.service;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.dto.BookDTO;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.book.SaveBookService;
import com.softdesign.libraryapi.services.book.UpdateBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UpdateBookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private UpdateBookService service;

    @Test
    void execute_shouldCallRepository() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName("name");

        when(repository.save(any())).thenReturn(new Book());

        service.update("id", bookDTO);

        verify(repository, times(1)).save(any());
    }
}
