package com.by.design_pattern.principle.singleResponsibility;

public class SingleResponsibility03 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

// 这种修改方法，没有对原来的类进行大的修改，只是增加了方法
// 在类级别上没有单一职责的原则，但是在方法的级别上是遵循单一职责原则的
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在路上运行");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空运行");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在路上运行");
    }
}
