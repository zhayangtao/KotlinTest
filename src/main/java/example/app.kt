package example


/**
 * @author zhayangtao
 * 2017/12/5
 */
fun main(args: Array<String>) {
    println("hello, world!")

    if (args.isEmpty()) {
        println("Please provide a name as a command-line argument");
        //return
    }
//    println("hello, ${args[0]}")

    for (name in args) {
        println("hello, $name!")
    }

    val language = if (args.isEmpty()) "EN" else args[0]
    println(when (language) {
        "EN" -> "Hello"
        "FR" -> "Salut"
        "IT" -> "Ciao"
        else -> "Sorry, I can't greet you in $language yet"
    })

    // 调用类方法
//    Greeter(args[0]).greet()

    //条件语句
//    println(max(args[0].toInt(), args[1].toInt()))
}

class Greeter(var name: String) {
    fun greet() {
        println("Hello, $name")
    }
}

fun max(a: Int, b: Int): Int ? = if (a > b) a else b
