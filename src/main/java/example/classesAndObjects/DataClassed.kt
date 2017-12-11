package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/10
 * @version 1.0
 * data classes
 * 1、必须包含至少一个参数
 * 2、所有的主构造器参数必须标记为val或者var
 * 3、不能为abstract、Open、sealed或inner
 */
private data class User(val name: String = "", val age: Int = 0) {
    constructor() : this(name = "", age = 0)
}

fun main(args: Array<String>) {
    println(User().toString())

    // copying
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)

    // 解构
    val jane = User("Jane", 33)
    val (name, age) = jane
    println("$name, $age years of age")
}