package com.softdesign.libraryapi.repository;

import com.softdesign.libraryapi.domain.Book;
import com.softdesign.libraryapi.domain.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, String> {

    Optional<BookRent> findByBookIdAndEndDate(String bookId, LocalDateTime data);

}
