package com.example.demo.bean.user.test;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class OicServAllOnlineDTO {

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 服务编码
     */
    private String servCode;

    /**
     * 服务名称
     */
    private String servName;

    /**
     * 服务简述
     */
    private String servSimpleDesc;

    /**
     * 服务规格编码
     */
    private String servSpecCode;

    /**
     * 服务扩展信息
     */
    private String servExt;

    /**
     * 是否删除
     */
    private String isDeleted;

    /**
     * 服务载体信息
     */
    private String servCarrierAll;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OicServAllOnlineDTO that = (OicServAllOnlineDTO) o;
        return Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(servCode, that.servCode)
                && Objects.equals(servName, that.servName)
                && Objects.equals(servSimpleDesc, that.servSimpleDesc)
                && Objects.equals(servSpecCode, that.servSpecCode)
                && Objects.equals(servExt, that.servExt) && Objects.equals(isDeleted, that.isDeleted)
                && Objects.equals(servCarrierAll, that.servCarrierAll);
    }
}
