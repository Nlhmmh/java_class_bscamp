package com.javaclass.exbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaclass.exbook.entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer>{

}
