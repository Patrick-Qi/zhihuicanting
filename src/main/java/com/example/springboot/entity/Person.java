package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private int id;
    private String name;
    private String username;

    private String password;
    private String Phone;
    private String createtime;
    private String updatetime;
}
