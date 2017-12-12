package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/11
 * @version 1.0
 * 委托  by
 */
private interface Base1 {
    fun print()
}
private class Base1Impl(val x: Int) : Base1 {
    override fun print() {
        println(x)
    }
}
private class Derived1(b: Base1) : Base1 by b

fun main(args: Array<String>) {
    val b = Base1Impl(10)
    Derived1(b).print()
}