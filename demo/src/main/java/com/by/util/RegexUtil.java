package com.by.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 工具类
 * @author wangby
 */
public class RegexUtil {

    /**
     * 从文本中提取所有和正则匹配的内容
     * @param pattern 正则表达式
     * @param text 要处理的文本
     * @return 匹配结果的 List
     */
    public static List<String> findAll(String pattern, String text) {
        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(text);

        List<String> results = new ArrayList<>();

        while(matcher.find()) {
            results.add(matcher.group());
        }

        return results;
    }

}
