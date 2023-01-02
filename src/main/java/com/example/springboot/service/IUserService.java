package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.User;

public interface IUserService {
    LoginDTO login(LoginRequest request);

    void save(User user);
}
