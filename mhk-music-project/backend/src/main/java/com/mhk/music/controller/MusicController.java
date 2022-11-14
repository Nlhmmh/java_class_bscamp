package com.mhk.music.controller;

import java.time.LocalDateTime;
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

import com.mhk.music.entity.Music;
import com.mhk.music.service.MusicServiceImp;

@RestController
@RequestMapping("/api")
public class MusicController {
	@Autowired
	MusicServiceImp service;
	@GetMapping("/music")
	List<Music> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/music/{id}")
	Music getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@PostMapping("/music")
	Music save(@RequestBody Music music) {
		music.setCreatedAt(LocalDateTime.now());
		return service.create(music);
	}
	
	@PutMapping("/music")
	ResponseEntity<?> update(@RequestBody Music music) {
		Music updatedMusic= service.update(music);
		if(updatedMusic==null) {
			return ResponseEntity.badRequest().body("Music cannot be updated");
		}
		return ResponseEntity.ok(updatedMusic);
	}
	
	@DeleteMapping("/music")
	ResponseEntity<?> delete(@RequestBody Music music){
		boolean isDeleted=service.delete(music.getId());
		if(isDeleted==false) {
			return ResponseEntity.badRequest().body("Music cannot be deleted");
		}
		return ResponseEntity.ok().build();
	}
}
