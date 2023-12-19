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
public class ServiceValidLightData extends LightData{
    /**
     * UPDATE操作的变更后的数据
     */
    private OicServAllOnlineDTO value;

    /**
     * 只有是UPDATE类型数据有值，为UPDATE操作的变更前的数据
     */
    private OicServAllOnlineDTO oldValue;

    @Override
    public String toString() {
        return "ServiceValidLightData{" +
                "value=" + value +
                ", oldValue=" + oldValue +
                '}';
    }
}
