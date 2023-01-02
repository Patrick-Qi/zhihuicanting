package com.example.springboot.service;

import com.example.springboot.entity.Orders;

import java.util.List;

public interface IOrdersService {
    void save(Orders obj);

    void update(Integer id);

    List<Orders> list();

    List<Orders> listByUserId(Integer id);
}
