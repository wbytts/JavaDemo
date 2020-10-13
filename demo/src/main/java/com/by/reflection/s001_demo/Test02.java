package com.by.reflection.s001_demo;

/**
 * 测试Class类对象的创建方式有哪些
 * @author bingyi
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        System.out.println("这个人是：" + student.name);

        // 方式1：通过对象获得 obj.getClass()
        Class c1 = student.getClass();
        System.out.println(c1);

        // 方式2：forName 获得
        Class c2 = Class.forName("com.by.reflection.s001_demo.Student");
        System.out.println(c2);

        // 方式3：通过类名 .class 获得
        Class c3 = Student.class;
        System.out.println(c3);

        // 方式4：基本内置类型的包装类都有一个 TYPE 属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        // 获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person {
    public String name;
    public String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

class Student extends Person {
    public String id;

    public Student(String name, String age, String id) {
        super(name, age);
        this.id = id;
    }

    public Student() {
    }


}