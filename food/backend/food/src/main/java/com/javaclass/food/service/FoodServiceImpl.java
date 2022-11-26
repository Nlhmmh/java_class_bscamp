package com.javaclass.food.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.food.model.Food;
import com.javaclass.food.repo.FoodRepo;

@Service
public class FoodServiceImpl implements FoodServiceInter{

	@Autowired
	FoodRepo repo;
	
	@Override
	public List<Food> getAll() {
		return repo.findAll();
	}

	@Override
	public Food get(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Food create(Food food) {
		food.setCreatedAt(LocalDateTime.now());
		return repo.save(food);
	}

	@Override
	public Food update(Food food) {
		Food findFood = repo.findById(food.getId()).orElse(null);
		if(findFood == null) {
			return null;
		}
		findFood.setName(food.getName());
		findFood.setPrice(food.getPrice());
		findFood.setType(food.getType());
		findFood.setUpdatedAt(LocalDateTime.now());
		return repo.save(findFood);
		
		//food.setUpdatedAt(LocalDateTime.now());
		//return repo.save(food);
	}

	@Override
	public boolean delete(int id) {
		Food findFood = repo.findById(id).orElse(null);
		if(findFood == null) {
			return false;
		}
		repo.deleteById(id);
		return true;
	}

}
