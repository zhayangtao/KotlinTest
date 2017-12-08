package example.classesAndObjects

import example.Foo
import org.junit.Test

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version 1.0
 * 属性与领域
 */
// 领域val变量可以使用get()方法
val isEmpty: Boolean
    get() = true
val anotherEmpty get() = false
var setterVisibility: String = "abc"
    // 设置为只读
    private set
var setterWithAnnotation: Any? = null
//    @Inject set

var counter = 0
    set(value) {
        // field标识符只能用于设置property
        if (value > 0) field = value
    }

private var _table: Map<String, Int>? = null
val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap()
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

// 编译期常量
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
private @Deprecated(SUBSYSTEM_DEPRECATED) fun deprecatedFoo() {}

// 懒加载属性和变量
private class MyTest() {
    lateinit var subject: String
    fun setUp() {
        subject = "1"
    }
    @Test
    fun test() {

    }
    // 检测一个属性是否已被初始化
    fun testInitialized() {

    }
}



private class Address {
    var name: String? = null
    val street: String? = null
}

// 使用属性
private fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    return result
}

// get/set方法
private fun testProps() {
    // 属性val变量不支持get()方法，只能在构造器中或者直接初始化
    val isNoEmpty: Boolean
}

fun main(args: Array<String>) {
    deprecatedFoo()
}