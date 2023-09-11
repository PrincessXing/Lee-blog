package com.lychee.utils;

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {
    }

    // 单个对象copy
    public static <V> V copy(Object source, Class<V> clazz) {
        // 创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            // 实现属性copy
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回目标对象
        return result;
    }

    // 多个对象copy
    public static <O,V> List<V> copyMultiple(List<O> source, Class<V> clazz) {
        // 创建目标对象
        return source.stream()
                .map(o -> copy(o, clazz))
                .collect(Collectors.toList());
    }

}
