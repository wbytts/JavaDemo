def c1 = {
    println '不带参数的闭包'
}

c1()

def c2 = {
    val -> println "带参数的闭包--->${val}"
}

c2(123)


// 定义指定类型接收不带参数的闭包的方法
def m1(Closure clo) {
    clo()
}

// 定义无指定类型接收带参数闭包的方法
def m2(clo) {
    clo("hello")
}

// 调用
m1(c1)
m2(c2)
// 省略括号
m1 c1
m2 c2

// 调用时定义闭包
m1({
    println 'Hello'
})
// 去掉括号
m2 {
    val -> println "Hello World ==> ${val}"
}
