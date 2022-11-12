package com.amta.book.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amta.book.entity.Book;
import com.amta.book.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {
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
		return repo.save(findBook);
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
