package com.javaclass.exbook.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.exbook.entity.Book;
import com.javaclass.exbook.repo.BookRepo;

@Service
public class BookService implements BookServiceInterface {

	@Autowired
	BookRepo repo;
	
	@Override
	public List<Book> getAllBook() {
		return repo.findAll();
	}

	@Override
	public Book getBook(int id) {
		return repo.findById(id).orElse(null);
	}
    @Override
	public Book createBook(Book book) {
    	book.setCreatedAt(LocalDateTime.now());
		return repo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		Book findBook = repo.findById(book.getId()).orElse(null);
		if(findBook !=null) {
			return null;
		}
		book.setUpdatedAt(LocalDateTime.now());
		return repo.save(book);
	}

	@Override
	public boolean delete(int id) {
		repo.deleteById(id);
		return true;
	}

}
