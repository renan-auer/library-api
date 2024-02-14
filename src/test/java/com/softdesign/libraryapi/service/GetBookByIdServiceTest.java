
package com.softdesign.libraryapi.service;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.repository.BookRepository;
import com.softdesign.libraryapi.services.book.GetBookByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetBookByIdServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private GetBookByIdService service;


    @Test
    void execute_shouldCallRepository() throws Exception {
        String id = "1";
        Book book = new Book();
        book.setName("name");

        when(repository.findById(any())).thenReturn(Optional.of(book));

        service.get(id);

        verify(repository, times(1)).findById(id);
    }
}
