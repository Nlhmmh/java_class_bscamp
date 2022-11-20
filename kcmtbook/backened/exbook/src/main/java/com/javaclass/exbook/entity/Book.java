package com.javaclass.exbook.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private int id;
	
	@Column(length=30,nullable=false)
     private String name;
	
	@Column(nullable=false)
	private String author;
	
	@Column(nullable=true)
     private int price;
	
	@Column(columnDefinition = "ENUM('romance','adventure','sciencefaction')")
	@Enumerated(EnumType.STRING)
     private BookType Type;
	
     private LocalDateTime publishedDate;
     
     @Column(nullable = true)
     @ColumnDefault("CURRENT_TimeSTAMP")
     private LocalDateTime createdAt;
     
     private LocalDateTime updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BookType getType() {
		return Type;
	}

	public void setType(BookType type) {
		Type = type;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
     
     
     
     
}
