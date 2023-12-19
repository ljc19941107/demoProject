package com.example.demo.bean.udstand;


import lombok.*;

/**
 * 理解属性
 * @author tanling.tl
 * @version $Id: UdstandAttribute.java, v 0.1 2023年05月03日 01:04 tanling.tl Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UdstandAttribute {

    /**
     * 属性id
     */
    private String           attributeId;

    /**
     * 属性名称
     */
    private String           attributeName;

    /**
     * 属性别名code 英文名称
     */
    private String           attributeAliasCode;

    /**
     * 关联业务属性
     */
    private String           bizAttributeId;



    /**
     * 属性类型
     */
    private String           attrType;

    /**
     * 是否多值 默认N
     */
    private String           isMulti;

    /**
     * 是否强审核 N不需要 Y需要
     */
    private String           whetherAudit;

    /**
     * 审核operator
     */
    private String           auditOperator;

    /**
     * 审核动作 {@link }
     */
    private String           auditAction;

    /**
     * 相关查询人
     */
    private String           queryOperatorId;

}