package com.javaclass.library.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.library.model.Book;
import com.javaclass.library.repo.LibraryRepo;

@Service
public class LibraryServiceImpl implements LibraryServiceInter {

	@Autowired
	LibraryRepo repo;
	
	@Override
	public List<Book> getAll() {
		return repo.findAll();
	}

	@Override
	public Book get(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Book create(Book book) {
		book.setCreatedAt(LocalDateTime.now());
		return repo.save(book);
	}

	@Override
	public Book update(Book book) {
		Book findBook = repo.findById(book.getId()).orElse(null);
		if( findBook == null ) {
			return null;
		}
		findBook.setName(book.getName());
		findBook.setAuthor(book.getAuthor());
		findBook.setPrice(book.getPrice());
		findBook.setType(book.getType());
		findBook.setPublishedDate(book.getPublishedDate());
		findBook.setUpdatedAt(LocalDateTime.now());
		
//		book.setCreatedAt(findBook.getCreatedAt());
//		book.setUpdatedAt(LocalDateTime.now());
		return repo.save(findBook);		
	}

	@Override
	public boolean delete(int id) {
		Book findBook = repo.findById(id).orElse(null);
		if( findBook == null ) {
			return false;
		}
		repo.deleteById(id);
		return true;
	}

}
