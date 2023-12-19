package com.example.demo.bean.udstand;

import lombok.Data;

/**
 * @author ljc
 * @version UdstandResultOutputRuleVO.java, v 0.1 2023年12月05日 下午1:57 ljc
 */
@Data
public class UdstandResultOutputRuleVO  {
    /**
     * 输出规则名id
     */
    private String outputRuleId;

    /**
     * 输出规则名称
     */
    private String outputRuleName;

    /**
     * 理解属性json
     */
    private String attributeJson;

    /**
     * 审核类型
     */
    private String auditType;

    /**
     * 审核model_json
     */
    private String auditModelJson;

    /**
     * 标签或特征json
     */
    private String featureTagJson;

    /**
     * 评测model_json
     */
    private String evaluateModelJson;

    /**
     * 状态
     */
    private String status;

}