package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/11
 * @version 1.0
 * 嵌套类
 */
fun main(args: Array<String>) {
    val demo = Outer2.Nested().foo()
    val demo2 = Outer3().Inner().foo()
}

private class Outer2 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

// inner class
private class Outer3 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

// 匿名内部类
