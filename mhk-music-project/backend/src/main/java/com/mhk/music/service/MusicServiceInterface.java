package com.mhk.music.service;

import java.util.List;

import com.mhk.music.entity.Music;


public interface MusicServiceInterface {
 public List<Music> getAll();
 
 public Music getById(int id);
 
 public Music create(Music music);
 
 public Music update(Music music);
 
 public boolean delete(int id);
 
 
}
