package com.example.springboot.mapper;


import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {
    User getByUsername(String username);
    User getById(Integer id);
    void save(User user);
    void updateById(User user);
}
