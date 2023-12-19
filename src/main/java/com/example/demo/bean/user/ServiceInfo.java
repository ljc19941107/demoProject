package com.example.demo.bean.user;

import java.util.HashMap;
import java.util.Map;

public class ServiceInfo {
    private static final long serialVersionUID = 1253106430890129191L;
    private String bizUniqId;
    private String name;
    private String subName;
    private String service;
    /** @deprecated */
    @Deprecated
    private String charset = "UTF-8";
    private String optType;
    private Map<String, Object> extendInfoMap = new HashMap();
    private String inspectConfig;
    private String alarmConfig;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBizUniqId() {
        return this.bizUniqId;
    }

    public void setBizUniqId(String bizUniqId) {
        this.bizUniqId = bizUniqId;
    }

    public String getSubName() {
        return this.subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getOptType() {
        return this.optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public Map<String, Object> getExtendInfoMap() {
        return this.extendInfoMap;
    }

    public void setExtendInfoMap(Map<String, Object> extendInfoMap) {
        this.extendInfoMap = extendInfoMap;
    }

    public String getInspectConfig() {
        return this.inspectConfig;
    }

    public void setInspectConfig(String inspectConfig) {
        this.inspectConfig = inspectConfig;
    }

    public String getAlarmConfig() {
        return this.alarmConfig;
    }

    public void setAlarmConfig(String alarmConfig) {
        this.alarmConfig = alarmConfig;
    }
}

