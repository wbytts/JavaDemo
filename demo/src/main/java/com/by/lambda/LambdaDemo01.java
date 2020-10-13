package com.by.lambda;

/**
 * 推导 lambda 表达式
 * @author bingyi
 */
public class LambdaDemo01 {
    /**
     * 静态内部类
     */
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    /**
     * 想办法把这个调用方式简化
     * @param args
     */
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        // 使用静态内部类
        like = new Like2();
        like.lambda();

        /**
         * 使用局部内部类
         */
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        // 使用匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        // 使用lambda表达式 （避免内部类定义过多）
        like = () -> System.out.println("i like lambda5");
        like.lambda();
    }
}

interface ILike {
    /**
     * 定义一个函数式接口
     */
    void lambda();
}

/**
 * 实现类
 */
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda1");
    }
}