package example

/**
 * @author zhayangtao
 * @since 2017/12/6
 * @version 1.0
 * 流程控制
 */

private fun testIfExpression() {
    var max = a
    var aTest = aVar
    var ma = if (1 > 2) {
        1
    } else {
        3
    }

}

fun fooTest(str: String): Int = when (str) {
    "a", "c" -> 1 or 5// or
    "b" -> 2
    !is String -> 5
    else -> 2
}

fun main(args: Array<String>) {
    System.out.println("Hello Java")
    println("Hello Kotlin")
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

//fun testBool(int: Int) = when (int) {
//
//}

private fun testWhen() {
    val x = 1
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        in 2..10 -> println("x is in 2 to 10")
        !in 10..20 -> println("x is outside 10 to 20")
        else -> println("unknown")
    }
}

private fun testForLoops() {
    val intArray = intArrayOf(1, 2, 3, 7, 5)
    for ((index, value) in intArray.withIndex()) {
        println("the element at $index is $value")
    }
}

private fun testWhileLoops() {
    var x = 100
    while (x > 0) {
        x--
    }
    do {
        val y: Int? = null
        print("do")
    } while (y != null)
}
