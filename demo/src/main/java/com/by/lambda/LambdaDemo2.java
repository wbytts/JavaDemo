package com.by.lambda;

/**
 * lambda表达式方法里只有一个语句的情况下，可以简化掉花括号
 * 可以简化参数类型
 * 前提是函数式接口
 * 多个参数也可以去掉参数类型（要去掉就都去掉）
 */

public class LambdaDemo2 {
    public static void main(String[] args) {


        ILove love = (int n) -> {
            System.out.println("i love you --> " + n);
        };

        // lambda表达式简化
        love = n -> System.out.println("i love you --> " + n);

        love.love(2);
    }
}

interface ILove {
    void love(int n);
}

class Love implements ILove {

    @Override
    public void love(int n) {
        System.out.println("i love you ---> " + n);
    }
}
