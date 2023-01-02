package com.example.springboot.service.impl;

import com.example.springboot.entity.Food;
import com.example.springboot.mapper.FoodMapper;
import com.example.springboot.service.IFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class FoodService implements IFoodService {
    @Resource
    FoodMapper foodMapper;

    @Override
    public Food getById(Integer id) {
        return foodMapper.getById(id);
    }

    @Override
    public List<Food> listByCategoryId(Integer categoryId){
        return foodMapper.listByCategoryId(categoryId);
    }
}
