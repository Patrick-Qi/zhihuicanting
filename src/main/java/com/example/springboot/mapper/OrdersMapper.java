package com.example.springboot.mapper;

import com.example.springboot.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    void save(Orders orders);

    void update(Orders order);

    Orders getById(Integer id);

    List<Orders> list();

    List<Orders> listByUserId(Integer id);
}
