package com.example.demo.bean.udstand;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AuditAction {

    /**
     * 审核条件组
     */
    private List<AuditCondition> auditConditions;

    /**
     * 审核
     */
    private List<AbstractResultAudit> resultAudits;




}