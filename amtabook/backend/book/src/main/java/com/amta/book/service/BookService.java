package com.amta.book.service;

import java.util.List;

import com.amta.book.entity.Book;

public interface BookService {
	public List<Book> getAll();

	public Book get(int id);

	public Book create(Book book);

	public Book update(Book book);

	public boolean delete(int id);
}
