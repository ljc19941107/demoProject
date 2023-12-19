package com.example.demo.bean.user.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LightData {

    /**
     * 数据库名称
     */
    private String lightDbName;

    /**
     * 表名称
     */
    private String lightTableName;

    /**
     * 数据变更时间
     */
    private String lightSyncModifyTime;

    /**
     * 变更类型，INSERT、UPDATE、DELETE、REPLACE
     */
    private String lightOperationType;
}
