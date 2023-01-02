package com.example.springboot.mapper;

import com.example.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    Category getById(Integer id);

    List<Category> list();
}
