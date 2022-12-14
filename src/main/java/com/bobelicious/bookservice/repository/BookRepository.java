package com.bobelicious.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobelicious.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
