package com.softdesign.libraryapi.repository;

import com.softdesign.libraryapi.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Page<Book> findAll(Pageable pageable);

}
