package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version 1.0
 * 扩展
 */
// 扩展函数功能
private fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

private fun<T> MutableList<T>.swapT(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>) {
    val lis = mutableListOf(1, 2, 3)
    lis.swap(1, 2)

    printFoo(BaseC()) // baseC
    printFoo(BaseD()) // baseC

    printFooD(BaseD())
}

private open class BaseC
private class BaseD: BaseC()

private fun BaseC.foo() = "baseC"
private fun BaseD.foo() = "baseD"

/*执行结果只与定义的参数有关，和运行期入参类型无关*/
private fun printFoo(c: BaseC) {
    println(c.foo())
}

private fun printFooD(d: BaseD) {
    print(d.foo())
}

// 类的成员方法会覆盖相同的扩展方法
private class BaseE {
    val foT: Int = 0

    fun foo() {
        println("member")
    }
}
private fun BaseE.foo() { // 扩展方法被覆盖
    println("extension")
}
private fun BaseE.foo(i: Int) {
    println("another extension")
}

// nullable receiver
private fun Any?.toString(): String {
    if (this == null) {
        return "null"
    }
    return toString()
}

// 扩展属性
private val <T> List<T>.lastIndex: Int
    get() = size - 1

//private val BaseE.foo: Int = 1

// 伴随对象扩展  Companion Object Extensions
/*
如同普通成员一样，可以使用类名最为标识符调用
*/
private class FoosClass {
    companion object {
    }
}
private fun FoosClass.Companion.foo() {
    println("FoosClass.Companion.foo")
}
private fun testCompanionObject() {
    FoosClass.foo()
}

// 将扩展声明为成员
private open class DeclareD {
    fun bar() {}
}
private open class DeclareC {
    fun baz() {}

    open fun DeclareD.foo() {
        bar()
        baz()
    }

    fun caller(d: DeclareD) {
        d.foo() // 调用扩展函数
    }
}

private class DeclareC1 : DeclareC() {
    override fun DeclareD.foo() {

    }
}
