package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: hspcadmin
 * @Date: 2022/6/24
 **/
@Data
public class Result<T> {

    private static final String  OK = "200";

    private String code;

    private String message;

    private T data;

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(String message, T data) {
        this.code = OK;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.code = OK;
        this.data = data;
    }
    public Result() {}
}
