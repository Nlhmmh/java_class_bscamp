package com.amta.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amta.book.entity.Book;
import com.amta.book.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	List<Book> getBooks(){
		return service.getAll();
	}
	
	@GetMapping("/books/{book_id}")
	Book getOneBook(@PathVariable("book_id") int bookId){
		return service.get(bookId);
	}

	@PostMapping("/books")
	Book create(@RequestBody Book book) {
		return service.create(book);
	}

	@PutMapping("/books")
	ResponseEntity<?> update(@RequestBody Book book) {
		Book updatedBook = service.update(book);
		if (updatedBook == null) {
			return ResponseEntity.badRequest().body("Book cannot be updated");
		}
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/books")
	ResponseEntity<?> delete(@RequestBody Book book) {
		 boolean isDeleted = service.delete(book.getId());
		 if (isDeleted == false) {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok().build();
	}
}
