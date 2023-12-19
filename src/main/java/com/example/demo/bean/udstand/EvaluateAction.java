package com.example.demo.bean.udstand;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EvaluateAction {

    /**
     * 评测周期
     */
    private UdstandResultEvaluatePeriod evaluatePeriod;

    /**
     * 评测报告
     */
    private String                      evaluateReport;
}