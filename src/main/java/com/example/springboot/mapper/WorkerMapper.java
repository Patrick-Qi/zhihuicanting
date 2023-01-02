package com.example.springboot.mapper;


import com.example.springboot.entity.Worker;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerMapper {
    Worker getByUsername(String username);
}
