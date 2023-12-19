package com.example.demo.service.user.impl;

import com.example.demo.bean.Result;
import com.example.demo.bean.user.UserDTO;
import com.example.demo.mapper.user.IUserMapper;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    //@Autowired
    private IUserMapper userMapper;

    @Override
    public Result<List<UserDTO>> getUserList(Integer userId) {
        return new Result<>("查询用户列表成功", userMapper.getUserList(userId));
    }
}
