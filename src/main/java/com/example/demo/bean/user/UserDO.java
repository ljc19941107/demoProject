package com.example.demo.bean.user;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: hspcadmin
 * @Date: 2022/6/23
 **/
@Data
public class UserDO {
    private Long id;

    private String name;

    private Date gmtCreate;
}
