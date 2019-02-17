package com.zfzn.firemaster.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 文本处理工具类
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:08
 */
public class TextUtils {
    /**
     * 判断字符串是否为空
     *
     * @param str 需要判断的参数
     * @return true（null或""）、false（其它）
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 需要判断的参数
     * @return true（）、false（null或""）
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断集合是否为空
     *
     * @param collection 参数
     * @return 结果
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断Map是否为空
     *
     * @param map 待判断Map
     * @return 检查结果
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * 连接 String 集合
     *
     * @param collection 待连接集合
     * @return 连接结果
     */
    public static String linkCollection(Collection<String> collection) {
        if (isEmpty(collection)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String str : collection) {
            builder.append(",");
            builder.append(str);
        }
        return builder.substring(1);
    }

    /**
     * 根据","切割字符串
     *
     * @param str 待切割字符串
     * @return 切割结果
     */
    public static List<String> cutStrToList(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

}
