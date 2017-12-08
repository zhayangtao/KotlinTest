package example

/**
 * @author zhayangtao
 * 2017/12/5
 */
fun main(args: Array<String>) {
//    cases("Hello")
//    cases(1)
//    cases(1L)
//    cases(MyClass())
    cases("hello")
    testStringTemplate()
    testForLoop()
    testWhileLoop()
    testOutOfRange()
}

private fun cases(obj: Any) {
    when (obj) {
        1 -> {
            println("One")
            println("hello")
        }
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

private class MyClass() {

    var size = null
    var allBY: Int? = null
    val simple: Int? = null

    val isEmpty: Boolean
        get() = this.size == 0

    fun increment() {
    }
}

// 使用string模板
private fun testStringTemplate() {
    var a = 1
    // simple name in template:
    val s1 = "a is $a"
    a = 2
    //模糊表达式
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

//使用if表达式
private fun maxOf(a: Int, b: Int) = if (a > b) a else b

// 使用nullable 表达式并且检查null，如果string不包含integer则返回null
private fun parseInt(string: String): Int? {
    //...
    return null
}

// 使用类型检查以及自动转型
private fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 自动类型转换
        return obj.length
    }
    return null
}

// 使用for循环
private fun testForLoop() {
    val items = listOf<String>("qqq", "banana", "kiwi");
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

// 使用while循环
private fun testWhileLoop() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// 使用when
private fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "not a string"
            else -> "Unknown"
        }


// 使用ranges
private fun testRange() {
    val x = 10
    val y = 9
    if (x in 1 until y + 1) {
        println("fits in range")
    }
}

// 检查数字是否越界
private fun testOutOfRange() {
    val list = listOf<String>("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println(list.size)
        println(list.indices)
        println("list size is out of valid list indices range too")
    }

    for (x in 1..10 step 2) {
        println(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        println(x)
    }
}

// 使用集合
private fun testCollections() {
    val items = listOf("a", "b", "c")
    for (item in items) {
        //...
    }
    when {
        "a" in items -> println("juicy")
        "c" !in items -> return
    }
}

// 使用lambda
private fun testLambda() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it -> it.startsWith("a") }.sortedBy { it }.map { it.toUpperCase() }.forEach { println(it) }
}

// 使用类
private abstract class Shape(private val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

private interface RectangleProperties {
    val isSquare: Boolean
}

private class Rectangle(private var height: Double, private var length: Double): Shape(listOf(height, length, height, length)), RectangleProperties {
    override fun calculateArea(): Double {
        TODO()
    }

    override val isSquare: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}

private class Triangle(var sideA: Double, var sideB: Double, var sideC: Double): Shape(listOf(sideA, sideB, sideC)) {
    override fun calculateArea(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}