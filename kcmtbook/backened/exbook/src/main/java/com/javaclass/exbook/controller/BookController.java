package com.javaclass.exbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaclass.exbook.entity.Book;
import com.javaclass.exbook.service.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService service;
    
    @GetMapping(path="/book")
    public List<Book>getAllBook(){
         return service.getAllBook();
    	
    }
    @GetMapping(path="/book/{id}") 
    public ResponseEntity< Book> getBook(int id) {
    	Book book = service.getBook(id);
    	if(book==null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    	return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
    @PostMapping(path="/book")
    public Book createBook(@RequestBody Book book) {
    	return service.createBook(book);
    }
    
    @PutMapping(path="/book/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book) {
    	book.setId(id);
    	return service.updateBook(book);
    }
    
    @DeleteMapping(path="/book/{id}")
    public boolean delete(@RequestBody Book book) {
    	return service.delete(book.getId());
    }
}

