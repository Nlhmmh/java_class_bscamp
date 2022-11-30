package com.vueClass.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vueClass.book.model.Book;

public interface BookServiceInter {
	public List<Book> getAll();
	
	public Book get(int id);
	
	public Book create(Book book);
	
	public Book update(Book book);
	
	public boolean delete(int id);
}
