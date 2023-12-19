package com.example.demo.bean.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UdstandAttributeValueRequest {

    /**
     * 属性值类型
     */
    private String                             attrValueType;

    /**
     * 属性编码
     */
    private String                             attributeId;

    /**
     * 属性值
     */
    private String                             attrValue;

    /**
     * 属性值列表
     */
    private List<UdstandAttributeValueRequest> valueList;
}