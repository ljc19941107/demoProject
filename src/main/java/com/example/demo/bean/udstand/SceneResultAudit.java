package com.example.demo.bean.udstand;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SceneResultAudit extends AbstractResultAudit {

    /**
     * 审核人
     */
    private List<String> auditor;
}