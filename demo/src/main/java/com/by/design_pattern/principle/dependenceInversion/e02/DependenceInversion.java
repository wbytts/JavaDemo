package com.by.design_pattern.principle.dependenceInversion.e02;

public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface IReceive {
    String getInfo();
}

class Email implements IReceive {
    @Override
    public String getInfo() {
        return "电子邮件信息：Hello World";
    }
}

class WeChat implements IReceive {
    @Override
    public String getInfo() {
        return "微信消息：Hello World";
    }
}

// 方式2
class Person {
    public void receive(IReceive receive) {
        System.out.println(receive.getInfo());
    }
}
