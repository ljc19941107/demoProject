package com.example.demo.bean.test;

public abstract class TestService {


    public String load() {
        return doLoad();
    }

    protected abstract String doLoad();

    protected abstract String getType();
}
