import com.by.groovy.demo.Student

// 就算不写带参构造函数，也可以通过具名函数方式初始化对象
Student s = new Student(username : "wangby",
                        age : 18,
                        email : "wangby@qq.com")

println s.getUsername()  // 调用自动生成的 getter、setter 方法
println s.age  // 私有属性也可以 点属性 来调用
println s.email

int a = 3
println "a = ${a}"
