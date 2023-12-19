package com.example.demo.bean.udstand;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author tanling.tl
 * @version $Id: ResultOutputActionMode.java, v 0.1 2023年11月28日 6:05 PM tanling.tl Exp $
 */
@AllArgsConstructor
@Getter
public enum ResultOutputActionMode {

    EXEMPT_AUDIT_MODE("EXEMPT_AUDIT_MODE", "免审模式"),

    GR_PERSONNEL_AUDIT_MODE("GR_PERSONNEL_AUDIT_MODE", "GR审&人审"),

    PERSONNEL_AUDIT_MODE("PERSONNEL_AUDIT_MODE", "人工审核"),

    GR_AUDIT_MODE("GR_AUDIT_MODE", "GR审"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;



    public static ResultOutputActionMode getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (ResultOutputActionMode item : ResultOutputActionMode.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

}
