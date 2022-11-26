package com.javaclass.food.service;

import java.util.List;

import com.javaclass.food.model.Food;

public interface FoodServiceInter {
	
	public List<Food> getAll();
	
	public Food get(int id);
	
	public Food create(Food food);
	
	public Food update(Food food);
	
	public boolean delete(int id);
}
