package example

import com.google.gson.Gson
import com.google.gson.JsonElement
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author zhayangtao
 * 2017/12/5
 * 习语
 */
// 函数默认值
private fun foo(a: Int = 0, b: String = "", c: Long) {
    TODO()
}

// list 过滤
private fun testListFilter() {
    val list = listOf("apple", "banana", "kiwi")
    var positives = list.filter { s -> s.startsWith("a") }
    // 使用it 指代变量
    positives = list.filter { it.startsWith("a") }
    TODO()
}

private fun testFoo(a: Int, b: Int): Int {
    TODO()
}

private fun testMap() {
    // 只读map
    var map = mapOf<String, Int>("a" to 1, "b" to 2)
}

// 懒属性
private fun testLazy() {
    val p: String by lazy {
        TODO()
    }
}

// 扩展函数
private fun String.spaceToCamelcase() {
    TODO()
}

fun main(args: Array<String>) {
//    println("hahah".spaceToCamelcase())
    // null判断
    val files = File("test").listFiles()
    println(files?.size)

    // 非 null判断
    println(files?.size ?: "empty")

    // null 则执行其他语句
    val values = mapOf<String, String>("aaa" to "apple")
//    val email = values["email"] ?: throw IllegalStateException("not found");
    // 非 null则执行
    /*values.let {

    }*/

    testTryResources();

}

// 创建单例对象
object Resource {
    val name = "name"
}

// 返回when 语句
fun testReturnWhen(color: String): Int {
    return when(color) {
        "Red" -> 0
        "Green" -> 1
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}
// 另一种写法
fun testReturnWhen2(color: String) = when (color) {
    "Red" -> 0
    "Green" -> 1
    else -> throw IllegalArgumentException("Invalid color param value")
}


// try catch
fun testTryCatch() {
    val result = try {
        1 / 0
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
}

// if
fun testIf(params: Int) {
    val result = if (params == 1) {
        "one"
    } else {
        "three"
    }
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

// 简单表达式函数
fun theAnswer()  = "the answer is blowing in the wind"
//等价于
fun theAnswer2(): String {
    return "the answer is blowing in the wind"
}

// 在 "with" 中调用类的多个方法
class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}
// test with
fun testWith() {
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

// java7 try resources
fun testTryResources() {
    val stream = Files.newInputStream(Paths.get("F:\\blog\\source\\_posts\\Untitled-1.txt"))
    stream?.buffered()?.reader().use { reader -> {
        println(reader?.readText())
    } }
}

// 泛型
inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java);

// nullablle Boolean
fun testNullableBoolean() {
    val b: Boolean? = 1 == 3
    if (b == true) {
        TODO()
    } else {
        TODO()
    }
}
