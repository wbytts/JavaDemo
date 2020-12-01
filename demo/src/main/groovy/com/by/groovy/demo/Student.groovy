package com.by.groovy.demo

// Groovy 默认不使用权限修饰符
// 默认是 公共的 public
class Student {
    // 没有权限修饰符的属性会自动生成 getter、setter 方法
    String username // 分号可以省略
    private int age
    def email // Groovy 定义属性的语法，弱类型
}







