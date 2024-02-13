package com.softdesign.libraryapi.repository;

import com.softdesign.libraryapi.domain.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, String> {

}
