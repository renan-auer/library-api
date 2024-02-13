package com.softdesign.libraryapi.repository;

import com.softdesign.libraryapi.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE " +
            "(:name is null or (:name is not null and b.name like CONCAT('%', :name,'%'))) AND" +
            "(:author is null or (:author is not null and b.author like CONCAT('%', :author,'%')))")
    Page<Book> findAll(Pageable page, @Param("name") String name, @Param("author") String author);
}
