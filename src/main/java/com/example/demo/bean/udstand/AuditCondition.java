package com.example.demo.bean.udstand;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AuditCondition {

    /** 特征关键字 */
    private String       featureKey;

    /** 运算函数 */
    private String       function;

    /** 预期值 */
    private List<String> expectedValue;

    /** 逻辑运算符 */
    private String       logicOperator;

    /** 排序 */
    private Integer      sort;

}