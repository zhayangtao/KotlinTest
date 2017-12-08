package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version 1.0
 * 可见修饰符
 */
/*若不加修饰符，则默认为 public
private修饰符：当前文件可见
internal：相同模块可见
protected：子类可见
内部类私有成员对外部类不可见
*/
internal val baz = 6

private open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        val e = 5
    }
}

private class Subclass : Outer() {
    override val b: Int = 4

}

fun main(args: Array<String>) {
    val subclass = Subclass()
    subclass.c
    subclass.d

}

// 构造器
private class C_ constructor(a: Int) {}