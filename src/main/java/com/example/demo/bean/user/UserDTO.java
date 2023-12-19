package com.example.demo.bean.user;

import lombok.Data;

import java.util.Map;

/**
 * @Description:
 * @Author: hspcadmin
 * @Date: 2022/6/23
 **/
@Data
public class UserDTO extends CommonDO{

    private Integer user_id;

    private String name;

    private Integer age;

    private Map<String ,Object> map;
}
