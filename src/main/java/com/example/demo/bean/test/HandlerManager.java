package com.example.demo.bean.test;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HandlerManager implements ApplicationContextAware {

    private final static Map<String, TestService> handlers = new HashMap<>(16);


    private static SingleServiceImpl pinlineServiceImpl;

    public static String getFeature() {


      return handlers.get("pipline").load();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, TestService> handlerMap = applicationContext.getBeansOfType(TestService.class);
        for (TestService handler : handlerMap.values()) {
            handlers.put(handler.getType(), handler);
        }


    }

}
