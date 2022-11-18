package com.javaclass.book.controller;

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

import com.javaclass.book.model.Book;
import com.javaclass.book.service.BookServiceInter;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookServiceInter bookService;
	
	@GetMapping("/getAll")
	List<Book> getAll(){
		return bookService.getAll();
	}
	
	@GetMapping("/getBookById/{id}")
	Book getBookById(@PathVariable("book_id") int bookId){
		return bookService.get(bookId);
	}
	
	@PostMapping("/create")
	Book create(@RequestBody Book book){
		return bookService.create(book);
	}
	
	@PutMapping("/update")
	ResponseEntity<?> update(@RequestBody Book book){
		Book updateBook = bookService.update(book);
		
		if(updateBook == null) {
			return ResponseEntity.badRequest().body("Book cannot be updated");
		}
		
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<?> delete(@RequestBody Book book){
		boolean isDeleted = bookService.delete(book.getId());
		
		if(isDeleted == false) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().build();
	}
}