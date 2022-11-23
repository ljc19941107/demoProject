package com.example.demo.controller.user;

import com.example.demo.bean.Result;
import com.example.demo.bean.user.UserDTO;
import com.example.demo.mapper.user.IUserMapper;
import com.example.demo.service.user.IUserService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: hspcadmin
 * @Date: 2022/6/23
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public Result<List<UserDTO>> getUserList(@RequestParam("userId") Integer userId) {
        log.info("请求参数=={}", userId);
        return userService.getUserList(userId);
    }

    public static void main(String[] args) {

//        for (int j = 0; j < 10; j++) {
//            double x = 0.0d;
//            double y = 0.0d;
//            int total = 0;
//            for (int i = 0; i < 7000000; i++) {
//                x = Math.random();
//                y = Math.random();
//
//                if (Math.sqrt(x*x + y*y) < 1) {
//                    total ++;
//                }
//            }
//            System.out.println(total/1000000.0);
//        }
        System.out.println(test(0));

    }

    public static int test(int i){
        try {
            i++;
        }finally {
            i++;
        }
        return i;
    }
}
