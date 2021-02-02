package com.by.design_pattern.principle.singleResponsibility;

/**
 * 单一职责原则-01
 */
public class SingleResponsibility01 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        // Vehicle 既负责路上的交通工具，又负责天上的交通工具，这就不合理了
        vehicle.run("飞机");
    }
}

// 交通工具类
// 这个类的run方法，违反了单一职责原则
// 解决方法：根据交通工具的运行方法不同，分解成不同的类
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在路上运行");
    }
}
