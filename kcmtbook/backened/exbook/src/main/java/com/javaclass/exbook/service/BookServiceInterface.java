package com.javaclass.exbook.service;

import java.util.List;

import com.javaclass.exbook.entity.Book;

public interface BookServiceInterface {
	
	 public List<Book>getAllBook();
      
      public Book getBook(int id);
      
      public Book createBook(Book book);
      
      public Book updateBook(Book book);
      
      public boolean delete(int id);
}
