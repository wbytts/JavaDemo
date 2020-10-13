package com.by.oop.contruct_method;

public class Person {
    private String name;
    private int age;

    /*
    如果不去定义构造方法，编译器会提供一个默认构造方法（什么也不干）
    如果定义了构造方法，系统就不会提供默认的构造方法
     */

    // 空的构造方法
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("wyb", 24);

        // 当用System.out.println 打印对象引用时，会自动调用对象的 toString方法，打印出它的返回值
        System.out.println(p1);
        System.out.println(p2);
    }
}
