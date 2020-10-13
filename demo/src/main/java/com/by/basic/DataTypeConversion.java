package com.by.basic;

/**
 * 基本数据类型转换：
 *      自动转换：当运算时数据类型不一样时，会发生类型转换
 *          转换规则：数据范围从小到大
 *          特点：
 *              代码不需要进行特殊处理，自动完成
 *              转换前后的数据类型兼容
 *              转换后的数据类型表示范围要比转换前的大
 *      强制转换：(要转换的类型) 要转换的内容
 *          特点：
 *              需要手动进行转换，明确要转换的类型
 *              # 会出现数据的丢失
 *              数据类型不兼容，一种不安全的转换
 *
 *      注意事项：
 *          1. 强制类型转换一般不推荐使用，容易出现精度损失，数据溢出
 *          2. byte、short、char 三者都可以发生数学运算，计算时首先提升为int，然后再计算
 *              * char 类型会转化为 ascii 之后 进行计算
 *          3. boolean类型不能发生数据类型转换
 * @author bingyi
 */
public class DataTypeConversion {
    public static void main(String[] args) {
        short s = 1;
        int i;
        // 自动类型转换， short转换成int，安全的
        i = s;

        // 强制类型转换
        double a = 1.33333;
        float b;
        b = (float)a;

        Character c1 = 98;
        Character c2 = 97 + 1;
    }
}
