package com.by.design_pattern.principle.singleResponsibility;

public class SingleResponsibility02 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();

        // 方案二：
        // 遵守了单一职责原则：// 单一职责：各行其职，独善其身
        // 但是这样做，改动很大，要将类分解，同时要修改客户端（即调用的代码）
        // 改进：直接修改原来的 Vehicle => 方案3
        roadVehicle.run("摩托车");
        airVehicle.run("飞机");
        waterVehicle.run("轮船");
    }
}




class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在路上运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在水中运行");
    }
}