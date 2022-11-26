package com.javaclass.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaclass.food.model.Food;

public interface FoodRepo extends JpaRepository<Food, Integer>{
	
}
