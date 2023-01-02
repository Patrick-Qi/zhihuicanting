package com.example.springboot.service;

import com.example.springboot.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category getById(Integer id);

    List<Category> list();
}
