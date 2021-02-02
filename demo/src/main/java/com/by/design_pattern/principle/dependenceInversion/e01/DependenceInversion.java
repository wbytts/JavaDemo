package com.by.design_pattern.principle.dependenceInversion.e01;

public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}


class Email {
    public String getInfo() {
        return "电子邮件信息：Hello World";
    }
}

// 问题：如果我们消息的来源是 微信、短信、qq等，就要新增类，Person里也要增加相应的方法
// 解决思路：引入一个抽象的接口 IReceive 表示接收者，Person类与这个接口发生依赖，其他具体的消息来源实现这个接口（细节（Person）依赖抽象（IReceive））
// 这时，增加一个消息来源时，只需要写这个具体的消息来源，Person和接口都不用修改
// 这样就符合依赖倒置原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
