package example.classesAndObjects

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * @author zhayangtao
 * @since 2017/12/11
 * @version 1.0
 * Object Expressions and Declarations
 * object 单例对象
 */
private open class A1(x: Int) {
    open val y: Int = x
}

private interface B1 {}

private val ab: A1 = object : A1(1), B1 {
    override val y: Int
        get() = 15
}

private fun objectFoo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

class C1 {
    private fun foo() = object {
        val x: String = "x"
    }

    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x   //private匿名对象的返回类型与object对象一致
        // public匿名对象返回类型是 Any
//        val x2 = publicFoo().x  //Error: Unresolved reference 'x'
    }
}

private fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent?) {
            enterCount++
        }
    })
}

// object declarations
private object DataProviderManager {
}

// companion objects
private class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
private class MyClass2 {
    companion object {
        fun create(): MyClass2 = MyClass2()
    }
}
private fun testMyClass() {
    val instance = MyClass.create()
    val instance2 = MyClass2.create()
}

// 伴随对象可以实现接口
private interface Factory<T> {
    fun create(): T
}
private class MyClass3 {
    companion object : Factory<MyClass3> {
        override fun create(): MyClass3 {
            TODO("not implemented")
        }
    }
}