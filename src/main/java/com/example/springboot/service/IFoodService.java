package com.example.springboot.service;

import com.example.springboot.entity.Food;

import java.util.List;

public interface IFoodService {
    Food getById(Integer id);
    List<Food> listByCategoryId(Integer categoryId);
}
