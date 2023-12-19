package com.example.demo.bean.udstand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultAuditActionType {

    ARTIFICIAL_AUDIT("ARTIFICIAL_AUDIT", "人工审核"),

    GR_AUDIT("GR_AUDIT", "GR审核");


    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;



    public static ResultAuditActionType getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (ResultAuditActionType item : ResultAuditActionType.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

}