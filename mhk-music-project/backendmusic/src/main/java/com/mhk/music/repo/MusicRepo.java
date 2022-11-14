package com.mhk.music.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhk.music.entity.Music;

public interface MusicRepo extends JpaRepository<Music, Integer> {

}
