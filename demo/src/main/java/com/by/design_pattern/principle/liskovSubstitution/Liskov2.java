package com.by.design_pattern.principle.liskovSubstitution;

public class Liskov2 {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        B1 b = new B1();
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
        System.out.println("11-3=" + b.func3(11, 3));
    }
}

// 一个更加基础的基类
class Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class A1 extends Base {

}

class B1 {

    private A a = new A();

    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }

    // 若仍想使用A中的方法
    public int func3(int num1, int num2) {
        return this.a.func1(num1, num2);
    }
}
