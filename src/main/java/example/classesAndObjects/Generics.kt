package example.classesAndObjects

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



