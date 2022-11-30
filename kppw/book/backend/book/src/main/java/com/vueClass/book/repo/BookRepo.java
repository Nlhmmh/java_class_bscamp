package com.vueClass.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vueClass.book.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
