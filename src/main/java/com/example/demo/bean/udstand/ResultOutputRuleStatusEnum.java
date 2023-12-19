package com.example.demo.bean.udstand;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 结果输出规则状态
 * @author ljc
 * @version ResultOutputRuleStatusEnum.java, v 0.1 2023年12月05日 上午10:27 ljc
 */
@AllArgsConstructor
@Getter
public enum ResultOutputRuleStatusEnum {


    VALID("VALID", "生效"),

    INVALID("INVALID", "失效");

    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    public static ResultOutputRuleStatusEnum getByCode(String code) {
        for (ResultOutputRuleStatusEnum item : ResultOutputRuleStatusEnum.values()) {
            if (StringUtils.equals(code, item.getCode())) {
                return item;
            }
        }
        return null;
    }

}
