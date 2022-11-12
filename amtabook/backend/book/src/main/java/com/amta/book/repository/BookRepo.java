package com.amta.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amta.book.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
