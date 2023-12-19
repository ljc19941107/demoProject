package com.example.demo;

import com.example.demo.bean.test.HandlerManager;
import com.example.demo.bean.test.TestService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

    @Autowired
    private Map<String, TestService> testServiceMap;


    @Resource
    private Map<String, TestService> map;

//    @Resource
//    private HandlerManager handlerManager;
    @Test
    public void contextLoads() {
        String feature = HandlerManager.getFeature();
        System.out.println(feature);
    }

    @Test
    public void handler() {


    }

}
