package example

/**
 * @author zhayangtao
 * 2017/12/5
 */
// 创建 DTO对象
data class Customer(private val name: String, var email: String)
data class User(val name: String = "", val age: Int = 0)


val jane = User("Jane", 30)
//val (name, age) = example.jane
fun main(args: Array<String>) {
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)

    val jane = User("Jane", 30)
    val (name, age) = jane
    println("$name, $age years of age")

    val customer = Customer(name = "a", email = "a")
    customer.email = "a";

}