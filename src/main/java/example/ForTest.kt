package example

/**
 * @author zhayangtao
 * 2017/12/5
 */
fun main(args: Array<String>) {
    for (arg in args) {
        print(arg)
    }
    println()

    for (i in args.indices) {
        println(args[i])
    }

    val x = 0;
    val y = 10;
    if (x in 1 until y) {
        println("ok")
    }

    // check if a number is out of range
    println()
    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if (x !in 0 until array.size) {
        println("Out: array has only")
    }

    if ("aaa" in array) {
        println("Yes: array contains aaa")
    }


}