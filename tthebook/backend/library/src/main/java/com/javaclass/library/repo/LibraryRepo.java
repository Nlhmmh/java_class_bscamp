package com.javaclass.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaclass.library.model.Book;

public interface LibraryRepo extends JpaRepository<Book, Integer> {

}
