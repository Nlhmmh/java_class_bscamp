package com.javaclass.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaclass.book.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}