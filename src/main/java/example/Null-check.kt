package example

/**
 * @author zhayangtao
 * @since 2017/12/5
 * @version 1.0
 */
fun main(args: Array<String>) {
    val x = parseInt("2")
    val y = parseInt("3")
    if (x != null && y != null) {
        println(x * y)
    }

    println(getStringLength("aaa"))
    println(getStringLength(1))
}
private fun parseInt(str: String): Int? {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        println("one of the arguments isn't Int")
    }
    return null
}

private fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}