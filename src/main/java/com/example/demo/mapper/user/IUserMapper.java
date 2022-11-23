package com.example.demo.mapper.user;

import com.example.demo.bean.user.UserDTO;

import java.util.List;

public interface IUserMapper {

    /**
     * 查询用户列表
     * @param userId userId
     * @return 用户列表
     */
    List<UserDTO> getUserList(Integer userId);
}
