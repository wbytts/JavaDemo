package com.by.design_pattern.principle.openClose.demo02;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}

/**
 * 这是一个用于绘图的类
 */
class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}


/**
 * 形状类（改为抽象类）
 */
abstract class Shape {
    abstract public void draw();
}

/**
 * 矩形类 继承 形状类
 */
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

/**
 * 圆形类 继承 形状类
 */
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

/**
 * 三角形 继承 形状类
 */
class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}