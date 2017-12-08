package example

//import java.io.*
/**
 * @author zhayangtao
 * @since 2017/12/6
 * @version 1.0
 * 基本类型
 */
// numbers  Double Float Long Int Short Byte
// 使用下划线使数字易读
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012
val a: Int = 10000
val boxedA: Int? = a
val anotherBoxedA: Int? = a
var aVar: Int? = null

//明确的原型
val bInt: Int? = 1
//val b: Long? = bInt  //error
val bByte: Byte = 1
//val i: Int = bByte   //error
val i: Int = bByte.toInt()
val longType = 1L + 3
val x = (1 shl 2)


fun main(args: Array<String>) {
    println(oneMillion)//1000000
    println(a === a)//true
    // === 比较对象地址
    println(boxedA === anotherBoxedA)//false
    // == 符号比较内容
    println(boxedA == anotherBoxedA)//true
    println("x = " + x)
//    println(1 < 2)
    println("-0.0 < 0.0 = " + (-0.0 < 0.0)) // true

    decimalDigitValue('9')//false

    xArray[0] = xArray[1] + xArray[2]
}

fun check(c: Char) {
//    if (c == 1) //error
}

fun decimalDigitValue(c: Char): Int {
    if (c !in '0' .. '9') {
        throw IllegalArgumentException("out of range")
    }
    return c.toInt() - '0'.toInt()
}

// 数组
val xArray: IntArray = intArrayOf(1, 2, 3)

//string，可以使用for循环
private fun testString() {
    check('0')

    if ("a" in "aaa") {
        println("hahhaha")
    }

    val text = """
         |for (c in "foo") {
         |   println(c)
         |}
    """.trimMargin("|")

    val i = 10
    val s = "i = $i" //

    val str = "$s.length is ${s.length}"

    val price = """
        ${'$'}9.88
    """.trimIndent()
}

class FooTest(i: Int, y: Long) {

}