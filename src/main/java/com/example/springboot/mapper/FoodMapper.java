package com.example.springboot.mapper;

import com.example.springboot.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    Food getById(Integer id);

    List<Food> listByCategoryId(Integer categoryId);
}
