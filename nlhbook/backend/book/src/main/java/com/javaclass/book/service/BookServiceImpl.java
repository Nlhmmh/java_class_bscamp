package com.javaclass.book.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.book.model.Book;
import com.javaclass.book.repo.BookRepo;

@Service
public class BookServiceImpl implements BookServiceInter {

	@Autowired
	BookRepo repo;

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
		if (findBook == null) {
			return null;
		}
		book.setUpdatedAt(LocalDateTime.now());
		return repo.save(book);
	}

	@Override
	public boolean delete(int id) {
		Book findBook = repo.findById(id).orElse(null);
		if (findBook == null) {
			return false;
		}
		repo.deleteById(id);
		return true;
	}

}
