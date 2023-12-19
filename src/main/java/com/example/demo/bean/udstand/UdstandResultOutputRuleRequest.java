package com.example.demo.bean.udstand;

import lombok.Data;

/**
 * 理解结果输出规则 request
 * @author ljc
 * @version UdstandResultOutputRuleRequest.java, v 0.1 2023年12月06日 上午9:49 ljc
 */
@Data
public class UdstandResultOutputRuleRequest {

    /**
     * 输出规则名id
     */
    private String outputRuleId;

    /**
     * 输出规则名称
     */
    private String outputRuleName;

    /**
     * 理解属性id
     */
    private String attributeId;

    /**
     * 审核model_json
     */
    private String auditModelJson;

    /**
     * 输出编码Json
     */
    private String outputCodeJson;

    /**
     * 评测model_json
     */
    private String evaluateModelJson;

    /**
     * 状态
     */
    private String status;

}