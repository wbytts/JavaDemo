package com.by.scala.demo.s005_DataType

object DataTypeDemo01 {
  def main(args: Array[String]): Unit = {
    var num1: Int = 10 // Int 点进去可以看到是一个class

    // 因为 Int 是一个类，所以它的实例就可以使用很多方法
    // 在Scala中，如果一个方法，没有形参，则可以省略
    println(num1.toDouble + "\t" + num1.toString())

    /*
        在Scala中，一切均为对象
        数据类型也是一种类，对象

        Scala的数据类型分两大类：AnyVal（值类型）、AnyRef（引用类型）
        不管是AnyVal还是AnyRef都是对象

        在Scala中，有一个根类型 Any 是所有类的父类

        Null 是 scala 的特别类型，它只有一个值 null
        Nothing 类型也是 bottom class，它是所有类的子类
            在开或发中通常可以将Nothing类型的值返回给任意变量者函数
            在抛出异常时经常使用

        在 scala 中仍然遵守低精度的值向高精度的值自动转换（隐式转换）

     */
  }
}
