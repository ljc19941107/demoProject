package com.example.demo.bean.udstand;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractResultAudit {

    /**
     * 审核类型
     */
    private ResultAuditActionType auditActionType;
}