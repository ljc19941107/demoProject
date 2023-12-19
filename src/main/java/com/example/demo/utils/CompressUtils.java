/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.demo.utils;
import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.util.Base64;
/**
 * 压缩工具类
 *
 * @author ljc
 */
public class CompressUtils {

    /**
     * Snappy压缩+base64编码
     *
     * @param source 源文本
     * @return 压缩结果
     */
    public static String compress(String source) {
        if (source == null) {
            return null;
        }

        byte[] compress = new byte[0];
        try {
            compress = Snappy.compress(source.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(compress);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * base64解码+Snappy解压
     *
     * @param base64 源文本
     * @return 解压结果
     */
    public static String unCompress(String base64) {
        if (base64 == null) {
            return null;
        }
        try {
            return new String(Snappy.uncompress(Base64.getDecoder().decode(base64)));
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException();
        }
    }
}
