package example.classesAndObjects

import example.Foo
import example.FooTest
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @author zhayangtao
 * @since 2017/12/11
 * @version 1.0
 * 委托属性
 */
private class Example {
    var p: String by Delegate()
}

private class Delegate {
    operator fun getValue(ref: Any?, property: KProperty<*>): String {
        return "$ref, thank you for delegating '${property.name}' to me !"
    }

    operator fun setValue(ref: Any?, property: KProperty<*>, s: String) {
        println("$s has been assigned to '${property.name}' in $ref")
    }
}
//i.e.
fun main(args: Array<String>) {
    val e = Example()
    println(e.p)
    e.p = "NEW"

    println(lazyValue)
    println(lazyValue)

    val user = User1()
    user.name = "first"
    user.name = "second"

}

/*
 Standard Delegates
 1、Lazy
 */
private val lazyValue: String by lazy {
    println("computed")
    "Hello"
}

/*
2、Observable
 */
private class User1 {
    var name: String by Delegates.observable("<no name>") {
        property, oldValue, newValue -> println("$oldValue -> $newValue")
    }
}

// Storing Properties in a Map
private class User2(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}
private fun testUser2() {
    val user = User2(mapOf("name" to "john", "age" to 25))
    println(user.name)
    println(user.age)
}
private class MutableUser2(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}
private fun testMutableUser2() {
    val user = MutableUser2(mutableMapOf("name" to "john", "age" to 25))
    println(user.name)
    println(user.age)
}

// Local Delegated Properties   本地委托属性
private fun example1(computeFoo: () -> FooTest) {
    val memorizedFoo by lazy(computeFoo)
}


// Property Delegate Requirements
//对于一个只读属性，“委托”必须提供一个名称为"getValue"包含两个参数"thisRef,property"的方法
//对于可变属性，“委托”必须提供一个名称为"setValue"包含两个参数"thisRef,property"的方法
private interface ReadOnlyProperty<in R, out T> {
    operator fun getValue(thisRef: R,property: KProperty<*>): T
}
private interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}

