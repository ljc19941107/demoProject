package com.example.demo.bean.udstand;

import java.util.List;
import java.util.Objects;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.ListUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import static com.example.demo.bean.udstand.ResultAuditActionType.ARTIFICIAL_AUDIT;
import static com.example.demo.bean.udstand.ResultAuditActionType.GR_AUDIT;
import static com.example.demo.bean.udstand.ResultOutputActionType.FEATURE_OUTPUT;
import static com.example.demo.bean.udstand.ResultOutputActionType.TAG_OUTPUT;

/**
 * @author ljc
 * @version UdstandResultOutputRuleConverter.java, v 0.1 2023年12月05日 上午10:22 ljc
 */
public class UdstandResultOutputRuleConverter {

    private static final String RESULT_AUDITS     = "resultAudits";

    private static final String OUTPUT_TYPE       = "outputActionType";

    private static final String AUDIT_ACTION_TYPE = "auditActionType";

    private static final String AUDIT_CONDITIONS  = "auditConditions";

    /**
     * model -> do
     * @param model
     * @return
     */
    public static UnderstandResultOutputRuleDO convertModel2DO(UdstandResultOutput model) {
        UnderstandResultOutputRuleDO outputRuleDO = new UnderstandResultOutputRuleDO();
        BeanUtils.copyProperties(model, outputRuleDO);
        //属性id
        outputRuleDO.setAttributeId(model.getUdstandAttribute().getAttributeId());
        //审核model_json
        outputRuleDO.setAuditModelJson(JSON.toJSONString(model.getAuditAction()));
        //审核类型
        outputRuleDO.setAuditType(model.getResultAuditActionMode().getCode());
        //评测model_json
        outputRuleDO.setEvaluateModelJson(JSON.toJSONString(model.getEvaluateAction()));
        //输出编码
        outputRuleDO.setOutputCode(model.getOutputCode());
        return outputRuleDO;
    }

    /**
     * do -> model
     * @param resultOutputRuleDO
     * @return
     */
    public static UdstandResultOutput convertDO2Model(UnderstandResultOutputRuleDO resultOutputRuleDO) {
        UdstandResultOutput outputRule = new UdstandResultOutput();
        outputRule.setOutputRuleId(resultOutputRuleDO.getOutputRuleId());
        outputRule.setOutputRuleName(resultOutputRuleDO.getOutputRuleName());
        //属性id
        outputRule.setUdstandAttribute(
                UdstandAttribute.builder().attributeId(resultOutputRuleDO.getAttributeId()).build());
        //审核动作
        outputRule.setAuditAction(getAuditAction(resultOutputRuleDO.getAuditModelJson()));

        //输出动作
        outputRule.setOutputActions(getOutputActionList(resultOutputRuleDO.getOutputCode()));

        //评测
        EvaluateAction evaluateAction = JSONObject
                .parseObject(resultOutputRuleDO.getEvaluateModelJson(), EvaluateAction.class);
        outputRule.setEvaluateAction(evaluateAction);

        outputRule.setStatus(ResultOutputRuleStatusEnum.getByCode(resultOutputRuleDO.getStatus()));
        return outputRule;
    }


    /**
     * request -> model
     * @param request
     * @return
     */
    public static UdstandResultOutput convertRequest2Model(UdstandResultOutputRuleRequest request) {
        UdstandResultOutput model = new UdstandResultOutput();


            //输出规则id
            model.setOutputRuleId(request.getOutputRuleId());
            //输出规则名称
            model.setOutputRuleName(request.getOutputRuleName());

            //理解属性id
            model.setUdstandAttribute(
                    UdstandAttribute.builder().attributeId(request.getAttributeId()).build());

            //审核动作
            model.setAuditAction(getAuditAction(request.getAuditModelJson()));

            //输出动作
            model.setOutputActions(Lists.newArrayList());
            JSONArray jsonArray = JSONArray.parseArray(request.getOutputCodeJson());
            if (CollectionUtils.isNotEmpty(jsonArray)) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    String outputType = jsonArray.getJSONObject(i).getString(OUTPUT_TYPE);
                    //特征输出
                    if (StringUtils.equalsIgnoreCase(outputType, FEATURE_OUTPUT.getCode())) {
                        model.getOutputActions().add(JSON.parseObject(
                                jsonArray.getJSONObject(i).toJSONString(), OutputFeatureAction.class));
                    } else if (StringUtils.equalsIgnoreCase(outputType, TAG_OUTPUT.getCode())) {
                        //标签输出
                        model.getOutputActions().add(JSON.parseObject(
                                jsonArray.getJSONObject(i).toJSONString(), OutputTagAction.class));

                    }
                }
            }

            //评测
            model.setEvaluateAction(
                    JSONObject.parseObject(request.getEvaluateModelJson(), EvaluateAction.class));


        return model;
    }

    /**
     * model -> vo
     * @param model
     * @return
     */
    public static UdstandResultOutputRuleVO convertModel2VO(UdstandResultOutput model) {
        UdstandResultOutputRuleVO outputRuleVO = new UdstandResultOutputRuleVO();
        outputRuleVO.setOutputRuleId(model.getOutputRuleId());
        outputRuleVO.setOutputRuleName(model.getOutputRuleName());
        //审核类型
        outputRuleVO.setAuditType(model.getResultAuditActionMode().getCode());
        //理解属性
        outputRuleVO.setAttributeJson(JSON.toJSONString(model.getUdstandAttribute()));

        //审核model_json
        outputRuleVO.setAuditModelJson(JSON.toJSONString(model.getAuditAction()));
        //审核类型
        outputRuleVO.setAuditType(model.getResultAuditActionMode().getCode());
        //评测model_json
        outputRuleVO.setEvaluateModelJson(JSON.toJSONString(model.getEvaluateAction()));
        //标签或特征
        outputRuleVO.setFeatureTagJson(JSON.toJSONString(model.getOutputActions()));
        outputRuleVO.setStatus(model.getStatus().getCode());

        return outputRuleVO;

    }

    public static List<OutputAction> getOutputActionList(String outputCode) {
        List<String> outputCodeList = ListUtils.convertStringToList(outputCode, ',');

        List<OutputAction> outputActionList = Lists.newArrayList();
        for (String outputCodeStr : outputCodeList) {
            String[] split = outputCodeStr.split("#");
            if (split[0].startsWith("F")) {
                OutputFeatureAction outputFeatureAction = new OutputFeatureAction();
                outputFeatureAction.setOutputActionType(FEATURE_OUTPUT);
                outputFeatureAction.setFeatureCode(split[1]);
                outputActionList.add(outputFeatureAction);
            }
            if (split[0].startsWith("T")) {
                OutputTagAction outputTagAction = new OutputTagAction();
                outputTagAction.setOutputActionType(TAG_OUTPUT);
                outputTagAction.setTagItemId(split[1]);
                outputActionList.add(outputTagAction);
            }
        }
        return outputActionList;
    }

    private static AuditAction getAuditAction(String auditModelJson) {
        JSONObject jsonObject = JSONObject.parseObject(auditModelJson);
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JSONArray jsonArray = jsonObject.getJSONArray(RESULT_AUDITS);

        List<AbstractResultAudit> abstractResultAudits = Lists.newArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            String auditActionType = jsonArray.getJSONObject(i).getString(AUDIT_ACTION_TYPE);
            //人工审核
            if (StringUtils.equalsIgnoreCase(auditActionType, ARTIFICIAL_AUDIT.getCode())) {
                abstractResultAudits.add(JSON.parseObject(jsonArray.getJSONObject(i).toJSONString(),
                        SceneResultAudit.class));
            }
            //gr审核
            if (StringUtils.equalsIgnoreCase(auditActionType, GR_AUDIT.getCode())) {
                abstractResultAudits.add(JSON.parseObject(jsonArray.getJSONObject(i).toJSONString(),
                        GrResultAudit.class));

            }
        }
        AuditAction auditAction = new AuditAction();
        auditAction.setResultAudits(abstractResultAudits);
        auditAction.setAuditConditions(JSONArray.parseArray(
                jsonObject.getJSONArray(AUDIT_CONDITIONS).toJSONString(), AuditCondition.class));
        return auditAction;
    }
}