package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;

public interface IWorkerService {
    LoginDTO login(LoginRequest request);
}
