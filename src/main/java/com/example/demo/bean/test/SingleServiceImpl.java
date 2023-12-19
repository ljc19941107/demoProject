package com.example.demo.bean.test;

import com.example.demo.utils.Constant;
import org.springframework.stereotype.Service;

@Service(Constant.SINGLE)
public class SingleServiceImpl extends TestService{

    @Override
    protected String doLoad() {
        return "SingleServiceImpl";
    }

    @Override
    protected String getType() {
        return "single";
    }
}
