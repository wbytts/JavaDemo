package com.by.scala.demo.s002_string

object Demo {
  def main(args: Array[String]): Unit = {
    var str1: String = "Hello"
    var str2: String = " world"
    println(str1 + str2)
    var name: String = "tom"
    var age: Int = 10
    var sal: Float = 10.67f
    var height: Double = 180.15
    printf("名字=%s, 年龄是%d, 薪水%.2f, 高%.3f\n", name, age, sal, height)
    // scala支持用$符输出内容
    println(s"个人信息如下：\n名字$name, 年龄$age, 薪水$sal, 高$height")

    // 还可以进行加减运算
    var n: Int = 24
    println(s"${n * n}, ${n + n}, ${n + n + n}")

    var arr = new Array[Int](10)
    for(item <- arr) {
      println("item=" + item)
    }
  }
}
