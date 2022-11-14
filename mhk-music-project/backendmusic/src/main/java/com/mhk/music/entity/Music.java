package com.mhk.music.entity;
import java.time.LocalDate;
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
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 30,nullable = false)
	private String name;
	
	@Column(columnDefinition = "ENUM('pop','rock','classic')")
	@Enumerated(EnumType.STRING)
	private MusicType type;
	
	@Column(nullable = false)
	private String singer;
	
	private LocalDate publishedDate;
	@Column(nullable = true)
	
	@ColumnDefault("CURRENT_TIMESTAMP")
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

	public MusicType getType() {
		return type;
	}

	public void setType(MusicType type) {
		this.type = type;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
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

	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", type=" + type + ", singer=" + singer + ", publishedDate="
				+ publishedDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
