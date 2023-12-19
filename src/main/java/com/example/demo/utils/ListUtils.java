package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtils {

    /**
     * Convert to list list.
     *
     * @param <T>              the type parameter
     * @param <R>              the type parameter
     * @param c                the c
     * @param convertInterface the convert interface
     * @return the list
     */
    public static <T, R> List<R> convertToList(Collection<T> c, Function<T, R> convertInterface) {
        List<R> list = new ArrayList<R>();
        if (c == null || c.isEmpty() || convertInterface == null) {
            return list;
        }
        for (T t : c) {
            if (t == null) {
                continue;
            }
            R r = convertInterface.apply(t);
            if (r != null) {
                list.add(r);
            }
        }
        return list;
    }

    /**
     * 将字符串按照分隔符转为字符串列表
     *
     * @param str
     * @param sep
     * @return
     */
    public static List<String> convertStringToList(String str, char sep) {
        String[] contents = StringUtils.split(str, sep);
        if (contents != null && contents.length > 0) {
            return Stream.of(contents).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
