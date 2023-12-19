package com.example.demo.bean.udstand;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 理解结果输出规则 实体
 *
 * @author ljc
 * @version UnderstandResultOutputRuleDO.java, v 0.1 2023年12月04日 上午10:32 ljc
 */
@Getter
@Setter
public class UnderstandResultOutputRuleDO {

    /**
     * 主键
     */
    private Long id;

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
     * 审核类型
     */
    private String auditType;

    /**
     * 审核model_json
     */
    private String auditModelJson;

    /**
     * 输出编码
     */
    private String outputCode;

    /**
     * 评测model_json
     */
    private String evaluateModelJson;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最近修改人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

}