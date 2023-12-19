package com.example.demo.bean.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CrawlerTaskContext {
    /**
     * 任务id
     */
    private String                      taskId;

    /**
     * 小程序ID
     */
    private String                      appId;

    /**
     * 采集子任务明细url和taskId列表
     */
    private List<CollectSubTaskContext> collectSubTaskContext;

    /**
     * 是否高保, 0否1是
     */
    private Integer                     isBizTop;
}
