package example

/**
 * @author zhayangtao
 * @since 2017/12/6
 * @version 1.0
 * 习惯编码用法
 */
// 冒号
interface Foo<out T : Any> {
    fun foo(a: Int): T
}

// lambda
private fun testLambda() {
    val list = listOf<String>("apple", "banana", "orange")
    list.filter { it.startsWith("a") }.map {it -> it.toUpperCase() }
}

// 带有少量参数的类可写成一行
private class Person(id: Int, name: String?)

// 继承
private open class Human(id: Int, name: String)
private class Student(id: Int, name: String) : Human(id, name)

// 返回 unit
private fun foo(): Unit {}