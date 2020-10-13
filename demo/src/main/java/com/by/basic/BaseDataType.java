package com.by.basic;

import org.junit.Test;

/**
 * 基本数据类型：
 *      整数：byte、short、int、long
 *      浮点数：float、double
 *      字符：char
 *      布尔：boolean
 *
 *  注意事项：
 *      * 字符串不是基本类型，而是引用类型
 *      * 浮点型可能只是一个近似值，并非精确的值
 *      * 数据范围与字节数不一定相关
 *      * 浮点数当中默认的类型是double，如果要使用float，要在后面加一个 F 或者 f
 *      * 整数的默认类型是 int，如果要使用 Long，要在后面加一个 L 或者 l
 * @author bingyi
 */
public class BaseDataType {

    @Test
    public void testZhengShu() {
        byte a = 3;
        short b = 4;
        int c = 5;
        long d = 6;
    }
}
