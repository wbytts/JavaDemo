// List集合，使用 [] 来声明集合
def list = [1, 2, 3, 4, 5]
println list
println list.getClass() // 查看类型

// 添加元素1，使用java自带的 add
list.add(9)
println list
// 方式2：
list << 123
println list