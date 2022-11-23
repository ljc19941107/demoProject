package com.example.demo.service.user;

import com.example.demo.bean.Result;
import com.example.demo.bean.user.UserDTO;

import java.util.List;


public interface IUserService {

    Result<List<UserDTO>> getUserList(Integer userId);
}
