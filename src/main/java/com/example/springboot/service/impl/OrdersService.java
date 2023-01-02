package com.example.springboot.service.impl;

import com.example.springboot.entity.Orders;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.FoodMapper;
import com.example.springboot.mapper.OrdersMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.valueOf;



@Service
@Slf4j
public class OrdersService implements IOrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    FoodMapper foodMapper;

    @Override
    @Transactional
    public void save(Orders obj){
        Integer useId=obj.getUserId();
        User user = userMapper.getById(useId);
        if (Objects.isNull(user)) {
            throw new ServiceException("用户不存在");
        }
        int count=0;
        String[] foodList=obj.getFoodId().split("-");
        String[] numList=obj.getNum().split("-");
        for(int i=0;i<foodList.length;i++){
            count = count+foodMapper.getById(valueOf(foodList[i])).getPrice()*valueOf(numList[i]);
        }
        int userCount=user.getCount();
        if (userCount < count) {
            throw new ServiceException("用户余额不足");
        }
        user.setCount(user.getCount() - count);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date date = new Date();//获得当前时间
        String time = df.format(date);
        user.setUpdatetime(time);
        userMapper.updateById(user);
        ordersMapper.save(obj);
    }
    public void update(Integer id){
        Orders orders=ordersMapper.getById(id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
        java.util.Date date = new Date();//获得当前时间
        String time = df.format(date);
        orders.setUpdatetime(time);
        orders.setStatus(0);
        ordersMapper.update(orders);
    }

    @Override
    public List<Orders> list() {
        return ordersMapper.list();
    }

    @Override
    public List<Orders> listByUserId(Integer id) {

        return ordersMapper.listByUserId(id);
    }
}
