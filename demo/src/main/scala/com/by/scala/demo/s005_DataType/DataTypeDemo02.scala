package com.by.scala.demo.s005_DataType

object DataTypeDemo02 {
  def main(args: Array[String]): Unit = {
    var ch: Char = 97
    println(ch)

    /*
        当把一个计算的结果赋值一个变量，则编译器会进行类型转换及判断（即会看范围+类型）
        当把一个字面量赋值一个变量，则编译器会进行范围的判定
     */
    var c1: Char = 98
//    var c2: Char = 97 + 1
//    var c4: Char = 'a' + 1
  }
}
