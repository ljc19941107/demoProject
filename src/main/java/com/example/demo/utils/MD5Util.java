/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.example.demo.utils;

import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author chenwei
 * @version $Id: MD5Util.java, v 0.1 2019年06月06日 11:26 AM chenwei Exp $
 */
public class MD5Util {

    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * md5 string
     *
     * @param text text
     * @return md5 string
     */
    public static String md5(String text) {
        try {
            return DigestUtils.md5Hex(text.getBytes(DEFAULT_CHARSET));
        } catch (Exception e) {

        }
        return null;
    }

    public static String md5UpperCase(String text) {
        return md5(text).toUpperCase();
    }

    /**
     * subString md5 string
     *
     * @param text       text
     * @param prefixLen  prefix length
     * @return subString
     */
    public static String md5(String text, int prefixLen) {
        return md5(text).substring(0, prefixLen);
    }

    /**
     * 默认按照key的自然顺序，将值以下划线分割进行md5
     * @param entityKeys
     * @return
     */
    public static String md5Sort(Map<String, String> entityKeys) {
        // 防止NPE，不能用Collector.toMap
        LinkedHashMap<String, String> sortKeys = entityKeys.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
        List<String> valList = Lists.newArrayList();
        for (Map.Entry<String, String> entry : sortKeys.entrySet()) {
            valList.add(entry.getValue());
        }
        // 单独一个key且长度小于32位的
        if (valList.size() == 1 && valList.get(0).length() <= 32) {
            return valList.get(0);
        }
        String joinPrimaryKey = valList.stream()
                .collect(Collectors.joining("_"));
        return MD5Util.md5(joinPrimaryKey);
    }

    public static void main(String[] args) {
        String str = "123_123";
        for (int i = 0; i < 10000; i++) {
            str +=i;
        }
        System.out.println(str);
        String s = md5(str);
        System.out.println(s);

    }
}