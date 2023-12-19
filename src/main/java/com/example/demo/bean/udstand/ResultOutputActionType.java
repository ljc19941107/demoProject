package com.example.demo.bean.udstand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  ResultOutputActionType {


    TAG_OUTPUT("TAG_OUTPUT", "标签输出"),

    FEATURE_OUTPUT("FEATURE_OUTPUT", "特征输出");


    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;



    public static ResultOutputActionType getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (ResultOutputActionType item : ResultOutputActionType.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }


}