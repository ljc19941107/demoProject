package com.example.demo.bean.udstand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OutputAction {

    /**
     * 输出结果动作类型
     */
    private ResultOutputActionType outputActionType;
}
