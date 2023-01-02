package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Worker;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.WorkerMapper;
import com.example.springboot.service.IWorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkerService implements IWorkerService {
    @Autowired
    WorkerMapper workerMapper;

    @Override
    public LoginDTO login(LoginRequest request) {
        Worker worker = null;
        try {
            worker = workerMapper.getByUsername(request.getUsername());
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsername());
            throw new ServiceException("用户名错误");
        }
        if (worker == null) {
            throw new ServiceException("用户名或密码错误");
        }
        // 判断密码是否合法
        String securePass = request.getPassword();
        if (!securePass.equals(worker.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(worker, loginDTO);
        return loginDTO;
    }
}
