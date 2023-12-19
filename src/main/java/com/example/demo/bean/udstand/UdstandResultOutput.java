package com.example.demo.bean.udstand;


import com.google.common.collect.Lists;
import lombok.*;
import org.apache.commons.collections.CollectionUtils;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * 理解结果输出
 * @author tanling.tl
 * @version $Id: UdstandResultOutput.java, v 0.1 2023年11月28日 4:28 PM tanling.tl Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UdstandResultOutput {

    /**
     * 输出规则名id
     */
    private String                     outputRuleId;

    /**
     * 输出规则名称
     */
    private String                     outputRuleName;

    /**
     * 状态
     */
    private ResultOutputRuleStatusEnum status;

    /**
     * 对象
     */
    private UdstandAttribute           udstandAttribute;

    /**
     * 审核动作
     */
    private AuditAction                auditAction;

    /**
     * 输出动作
     */
    private List<OutputAction>         outputActions;

    /**
     * 评测
     */
    private EvaluateAction             evaluateAction;

    /**
     * 审核模式
     * @return
     */
    public ResultOutputActionMode getResultAuditActionMode() {

        if (Objects.isNull(auditAction)) {
            return ResultOutputActionMode.EXEMPT_AUDIT_MODE;
        }

        if (CollectionUtils.isNotEmpty(auditAction.getResultAudits())) {
            if (auditAction.getResultAudits().stream()
                    .filter(x -> x.getAuditActionType() == ResultAuditActionType.ARTIFICIAL_AUDIT)
                    .findAny().isPresent()
                    && auditAction.getResultAudits().stream()
                    .filter(x -> x.getAuditActionType() == ResultAuditActionType.GR_AUDIT).findAny()
                    .isPresent()) {
                return ResultOutputActionMode.GR_PERSONNEL_AUDIT_MODE;
            }

            else if (auditAction.getResultAudits().stream()
                    .filter(x -> x.getAuditActionType() == ResultAuditActionType.ARTIFICIAL_AUDIT)
                    .findAny().isPresent()) {
                return ResultOutputActionMode.PERSONNEL_AUDIT_MODE;
            }

            else if (auditAction.getResultAudits().stream()
                    .filter(x -> x.getAuditActionType() == ResultAuditActionType.GR_AUDIT).findAny()
                    .isPresent()) {
                return ResultOutputActionMode.GR_AUDIT_MODE;
            }

        }

        return ResultOutputActionMode.EXEMPT_AUDIT_MODE;

    }

    /**
     * 获取输出编码 F#xxx,F#xxx,T#xxx,T#xxx
     * @return
     */
    public String getOutputCode() {
        if (CollectionUtils.isEmpty(outputActions)) {
            return StringUtils.EMPTY;
        }
        List<String> list = Lists.newArrayList();
        for (OutputAction outputAction : outputActions) {
            if (outputAction instanceof OutputFeatureAction) {
                list.add("F#" + ((OutputFeatureAction) outputAction).getFeatureCode());

            } else if (outputAction instanceof OutputTagAction) {
                list.add("T#" + ((OutputTagAction) outputAction).getTagItemId());

            }
        }
        return StringUtils.join(list, ",");
    }
}