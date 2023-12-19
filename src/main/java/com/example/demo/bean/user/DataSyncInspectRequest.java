package com.example.demo.bean.user;

import java.util.ArrayList;
import java.util.List;

public class DataSyncInspectRequest  {
    private static final long serialVersionUID = 322445218244259154L;
    private boolean isInspect;
    private boolean isNotify;
    private String outBizNo;
    private String appId;
    private String creator;
    private String bizType;
    private String dataFromType;
    private String detectType;
    private List<ServiceInfo> serviceInfoList;
    private Boolean pageTask;

    public DataSyncInspectRequest() {
        this.isInspect = Boolean.FALSE;
        this.isNotify = Boolean.FALSE;
        this.serviceInfoList = new ArrayList();
        this.pageTask = Boolean.FALSE;
    }

    public String getOutBizNo() {
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isInspect() {
        return this.isInspect;
    }

    public void setInspect(boolean isInspect) {
        this.isInspect = isInspect;
    }

    public List<ServiceInfo> getServiceInfoList() {
        return this.serviceInfoList;
    }

    public void setServiceInfoList(List<ServiceInfo> serviceInfoList) {
        this.serviceInfoList = serviceInfoList;
    }

    public String getDataFromType() {
        return this.dataFromType;
    }

    public void setDataFromType(String dataFromType) {
        this.dataFromType = dataFromType;
    }

    public boolean isNotify() {
        return this.isNotify;
    }

    public void setNotify(boolean isNotify) {
        this.isNotify = isNotify;
    }

    public String getDetectType() {
        return this.detectType;
    }

    public void setDetectType(String detectType) {
        this.detectType = detectType;
    }

    public Boolean getPageTask() {
        return this.pageTask;
    }

    public void setPageTask(Boolean pageTask) {
        this.pageTask = pageTask;
    }
}
