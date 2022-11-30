package com.vueClass.book.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vueClass.book.model.Book;
import com.vueClass.book.repo.BookRepo;

@Service
public class BookServiceImple implements BookServiceInter {
	
	@Autowired
	BookRepo repo;

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
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
		if(findBook == null) {
			return null;
		}
		//book.setCreatedAt(findBook.getCreatedAt());
		//book.setUpdatedAt(LocalDateTime.now());
		findBook.setName(book.getName());
		findBook.setAuthor(book.getAuthor());
		findBook.setPrice(book.getPrice());
		findBook.setType(book.getType());
		findBook.setPublishDate(book.getPublishDate());
		findBook.setUpdatedAt(LocalDateTime.now());
		
		return repo.save(book);
	}

	@Override
	public boolean delete(int id) {
		Book findBook = repo.findById(id).orElse(null);
		if(findBook == null) {
			return false;
		}
		repo.deleteById(id);
		return true;
	}

}
