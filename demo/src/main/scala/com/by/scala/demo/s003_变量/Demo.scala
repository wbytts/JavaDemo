package com.by.scala.demo.s003_变量

object Demo {
  def main(args: Array[String]): Unit = {
    // 编译器，动态的（逃逸分析）
    var age: Int = 10
    var name: String = "tom"
    var isPass: Boolean = true
    // 在scala中，小数默认为Double，整数默认为Int
    var score: Float = 60.9f

    println(s"${age} ${isPass}")



    // 类型推导
    var num = 10 // 这时 num 就是 int
    println(num.isInstanceOf[Int])

    // 类型确定了之后，就不能修改，说明 Scala是强类型语言

    /*
        var 修饰的变量可以改变
        val 修饰的变量不可以修改
            val没有线程安全问题，因此效率高
     */

    val dog = new Dog
    //dog = new Dog // 这句话会报错
  }
}

class Dog {
  // 声明一个age，可以给一个默认值 _
  var age: Int = 0
  // 声明名字
  var name: String = ""
}
