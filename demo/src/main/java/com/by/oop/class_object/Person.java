package com.by.oop.class_object;

public class Person {

    String name;
    int age;

    public void speak(String ...hobbies) {
        System.out.println("我叫" + name + ", 我今年" + age + "岁了");
        System.out.println("我一共有" + hobbies.length + "个爱好");
        for(String hobby : hobbies) {
            System.out.println("我喜欢: " + hobby);
        }
    }

    public static void main(String[] args) {
        // 创建一个对象
        Person p = new Person();
        // 给对象的属性赋值
        p.name = "wby";
        p.age = 24;
        // 调用对象的方法
        p.speak("吃", "喝", "玩", "乐");
    }
}
