package example.classesAndObjects

import java.util.Collections.copy

/**
 * @author zhayangtao
 * @since 2017/12/10
 * @version 1.0
 * 泛型
 */
private class Box<T>(t: T) {
    var value = t
}

fun main(args: Array<String>) {
    val box: Box<Int> = Box(1)
    val hidden = Box(1)
    print(1)
}

/*
// java 写法
interface Source<T> {
    T nextT()
}*/

// declaration-site variance
private abstract class Source<out T> {
    abstract fun nextT(): T
}
private fun outDemo(strs: Source<String>) {
    val objets: Source<Any> = strs   //协变
}

private abstract class Comp<in T> {
    abstract fun comp(other: T): Int
}
private fun inDemo(x: Comp<Number>) {
    x.comp(1.0)
    val y: Comp<Double> = x //逆变
}

// 实例
private fun testTypeProject() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3){""}
//    copy1(ints, any)   //Error
    copy2(ints, any)
}

private fun copy1(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] =  from[i]
    }
}

private fun copy2(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] =  from[i]
    }
}

/*
star-projections
i.e. TUpper.Foo<*> = Foo<out TUpper>
Foo<*> = Foo<in Nothing>
Fun<*, String> = Fun<in Nothing, String>
Fun<Int, *> = Fun<Int, out Any?>
Fun<*, *> = Fun<in Nothing, out Any?>
 */

// 泛型函数
private fun <T> singletonList(item: T): List<T> {
    return listOf<T>()
}
private fun <T> T.basicToString(): String? {
    return null
}

// 泛型约束
private fun <T: Comparable<T>> sort(list: List<T>) {}
private fun testSort() {
    sort(listOf(1, 2, 3))
//    sort(listOf(HashMap<Int, String>())) // error

}

/*private fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
        where T: Comparable<T>, T: Cloneable {
    return list.filter { it > threshold }.map { it.clone() }
}*/
