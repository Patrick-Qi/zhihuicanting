package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Food {
    private int id;
    private int categoryId;
    private String name;
    private int price;
    private String ingredient;
    private String createtime;
    private String updatetime;
}
