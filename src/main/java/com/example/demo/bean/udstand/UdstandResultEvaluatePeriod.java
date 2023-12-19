package com.example.demo.bean.udstand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UdstandResultEvaluatePeriod {


    NEVER_EVALUATE("NO_EVALUATE", "不评测"),

    ONCE_WEEK_EVALUATE("ONCE_WEEK_EVALUATE", "一周评一次"),

    ONCE_MONTH_EVALUATE("ONCE_MONTH_EVALUATE", "一月评一次");



    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;



    public static UdstandResultEvaluatePeriod getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (UdstandResultEvaluatePeriod item : UdstandResultEvaluatePeriod.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

}