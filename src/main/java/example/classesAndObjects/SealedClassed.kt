package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/10
 * @version 1.0
 * sealed class不能有非private的构造器但可以包含抽象成员
 */
private sealed class Expr
private data class Const(val number: Double) : Expr()
private data class Sum(val e1: Expr, val e2: Expr) : Expr()
private object NotANumber : Expr()

fun main(args: Array<String>) {
    Const(1.2)
}

// the use of sealed class
private fun eval(expr: Expr) : Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}