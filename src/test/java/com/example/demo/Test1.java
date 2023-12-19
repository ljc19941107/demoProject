package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.example.demo.bean.user.UserDO;
import com.example.demo.utils.MD5Util;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javafx.scene.input.DataFormat;
import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        List<UserDO> commonTaskModels = Lists.newArrayList();
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("1");
        userDO.setGmtCreate(new Date());


        UserDO userDO1 = new UserDO();
        userDO1.setId(2L);
        userDO1.setName("1");
        userDO1.setGmtCreate(new Date());

        commonTaskModels.add(userDO);
        commonTaskModels.add(userDO1);


        UserDO userDO3 = commonTaskModels.stream()
                .filter(
                        commonTaskModel -> commonTaskModel.getName().equals("1")).max(Comparator.comparing(UserDO::getGmtCreate)).orElse(null);
        System.out.println(JSON.toJSONString(userDO3));



    }


}
