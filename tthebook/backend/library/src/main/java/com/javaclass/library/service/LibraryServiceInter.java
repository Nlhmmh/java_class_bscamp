package com.javaclass.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaclass.library.model.Book;

public interface LibraryServiceInter {
	
	public List<Book> getAll();
	
	public Book get(int id);
	
	public Book create(Book book);
	
	public Book update(Book book);
	
	public boolean delete(int id);

}
