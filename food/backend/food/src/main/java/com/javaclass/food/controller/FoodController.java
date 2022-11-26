package com.javaclass.food.controller;

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

import com.javaclass.food.model.Food;
import com.javaclass.food.service.FoodServiceInter;

@RestController
@RequestMapping("/api")
public class FoodController {
	@Autowired
	FoodServiceInter service;
	
	@GetMapping("/food")
	List<Food> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/food/{food_id}")
	Food get(@PathVariable("food_id") int foodID) {
		return service.get(foodID);
	}
	
	@PostMapping("/food")
	Food create(@RequestBody Food food) {
		return service.create(food);
	}
	
	@PutMapping("/food")
	ResponseEntity<?> update(@RequestBody Food food) {
		Food updateFood = service.update(food);
		if(updateFood == null) {
			return ResponseEntity.badRequest().body("Food cannot be update!");
		}
		return ResponseEntity.ok(updateFood);
	}
	
	@DeleteMapping("/food")
	ResponseEntity<?> delete(@RequestBody Food food) {
		boolean isDeleted = service.delete(food.getId());
		if(isDeleted == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
