package com.mhk.music.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhk.music.entity.Music;
import com.mhk.music.repo.MusicRepo;
@Service
public class MusicServiceImp implements MusicServiceInterface{
	
	@Autowired
	MusicRepo repo;

	@Override
	public List<Music> getAll() {
		return repo.findAll();
	}

	@Override
	public Music getById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Music create(Music music) {
		return repo.save(music);
	}

	@Override
	public boolean delete(int id) {
		Music findMusic=repo.findById(id).orElse(null);
		if(findMusic==null) {
			return false;
		}
		 repo.deleteById(id);
		 return true;
	}

	@Override
	public Music update(Music music) {
		Music findMusic=repo.findById(music.getId()).orElse(null);
		if(findMusic==null) {
			return null;
		}
		music.setUpdatedAt(LocalDateTime.now());		
		return repo.save(music);
	}

}
