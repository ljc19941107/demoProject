package com.example.demo.bean.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectSubTaskContext {

    /**
     * 采集子任务id
     */
    private String taskId;

    /**
     * url
     */
    private String url;

}