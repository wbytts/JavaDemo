package com.by.design_pattern.principle.openClose.demo01;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        // 绘制矩形
        graphicEditor.drawShape(new Rectangle());
        // 绘制圆形
        graphicEditor.drawShape(new Circle());

        /*
            违反了 OCP规则：对扩展开放，对修改关闭
            若新增了一个Shape子类之后，GraphicEditor 就要添加对应的函数和判断，否则就会出问题
         */
    }
}

/**
 * 这是一个用于绘图的类
 */
class GraphicEditor {
    public void drawShape(Shape s) {
        if(s.mType == 1) {
            drawRectangle(s);
        } else if (s.mType == 2) {
            drawCircle(s);
        } else if(s.mType == 3) {
            drawTriangle(s);
        }
    }

    public void drawRectangle(Shape s) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape s) {
        System.out.println("圆形");
    }

    public void drawTriangle(Shape s) {
        System.out.println("三角形");
    }
}


/**
 * 形状类
 */
class Shape {
    int mType;
}

/**
 * 矩形类 继承 形状类
 */
class Rectangle extends Shape {
    public Rectangle() {
        super.mType = 1;
    }
}

/**
 * 圆形类 继承 形状类
 */
class Circle extends Shape {
    public Circle() {
        super.mType = 2;
    }
}

/**
 * 三角形 继承 形状类
 */
class Triangle extends Shape {
    public Triangle() {
        super.mType = 3;
    }
}