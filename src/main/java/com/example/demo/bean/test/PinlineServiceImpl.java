package com.example.demo.bean.test;

import com.example.demo.utils.Constant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(Constant.PIPLINE)
public class PinlineServiceImpl extends TestService{
    @Override
    protected String doLoad() {
        return "PinlineServiceImpl";
    }

    @Override
    protected String getType() {
        return "pipline";
    }
}
