package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Category {
    private Integer id;
    private String name;
    private String createtime;
    private String updatetime;
}
