package com.example.springboot.controller;


import com.example.springboot.common.Result;

import com.example.springboot.entity.Food;

import com.example.springboot.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Food obj = foodService.getById(id);
        if(obj==null){
            return Result.error("-1","无此菜品");
        }
        return Result.success(obj);
    }
    @GetMapping("/list/{categoryId}")
    public Result listByCategoryId(@PathVariable Integer categoryId){
        List<Food> list = foodService.listByCategoryId(categoryId);
        if(list.size()==0)
        {
            return Result.error("-1","无此菜品分类或该分类下没有菜品");
        }
        return Result.success(list);
    }
}
