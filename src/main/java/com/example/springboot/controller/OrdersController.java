package com.example.springboot.controller;


import com.example.springboot.common.Result;
import com.example.springboot.entity.Category;
import com.example.springboot.entity.Orders;
import com.example.springboot.service.IOrdersService;
import com.example.springboot.service.impl.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    IOrdersService ordersService;

    @PostMapping("/save")
    public Result save(@RequestBody Orders obj) {
        ordersService.save(obj);
        return Result.success();
    }
    @GetMapping("/update/{id}")
    public Result update(@PathVariable Integer id){
        ordersService.update(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        List<Orders> list = ordersService.list();
        return Result.success(list);
    }
    @GetMapping("/listByUserId/{id}")
    public Result listByUser(@PathVariable Integer id){
        List<Orders> list = ordersService.listByUserId(id);
        if(list.size()==0)
        {
            return Result.error("-1","用户不存在");
        }
        return Result.success(list);
    }
}
