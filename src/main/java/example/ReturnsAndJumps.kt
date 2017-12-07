package example

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version 1.0
 */
fun main(args: Array<String>) {
    testBreakLabels()
}
private fun testBreakLabels() {
    loop@ for (i in 1..10) {
        for (j in 1..100) {
            if (j > 45) {
                break@loop
            }
        }
    }

    for (i in 1..10) {
        (1..100)
                .filter { it <= 45 }.forEach(::println)
    }
}

// return,返回标签处
private fun testReturnLabels() {
    //e.g 1
    val ints = intArrayOf(1, 4, 5, 6, 9)
    ints.forEach {
        if (it == 0) return
        println(it)
    }

    //e.g 2
    ints.forEach lit@ {
        if (it == 0) return@lit
        println(it)
    }

    //e.g 3 隐式标签
    ints.forEach {
        if (it == 0) return@forEach
        println(it)
    }

    // 用匿名函数替代lambda
    ints.forEach { fun (value: Int) {
        if (value == 0) return
        println(value)
    } }

}