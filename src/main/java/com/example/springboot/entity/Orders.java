package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private int id;
    private int userId;
    private String num;
    private String foodId;
    private int tableNum;
    private int status;
    private String createtime;
    private String updatetime;
}
