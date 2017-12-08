package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version
 */
fun main(args: Array<String>) {
    InitOrderDemo("lili")
    Constructors(5);
    /*DontCreateMe("lil")
    Customer()
    println("invoke class C")
    C().f()*/
}

private class Invoice {

}

private class Empty

// constructors, the constructor in the head is primary
private class Person constructor(firstName: String) {
    // secondary constructor
//    constructor() : this("")

    //third constructor
    constructor(firstName: String, lastName: String) : this("")

}

// Initialization code can be placed in initializer blocks,
// 初始化模块的顺序与它们在类中声明的顺序一致，此处先初始化firstProperty，再是 init、secondProperty、init
private class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)/*.also { it -> println(it) }*/

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer")
    }
}

// 简便写法
private class Person2(val firstName: String, val lastName: String, var age: Int)

//
//private class Customer public @Inject constructor(name: String)

// init代码是作为primary constructor一部分的，类先初始化 primary constructor，然后是 secondary
private class Constructors {
    init {
        println("Init block")
    }

    // secondary constructor
    constructor(i: Int) {
        println("second contructor")
    }
}

// 一个类默认带有 public 的不含参数 primary constructor，可以覆盖
private class DontCreateMe private constructor() {
    constructor(firstName: String) : this()
}

// 如果一个类带有默认参数，则编译器会自动生成一个无参构造器
private class Customer(val customerName: String = "")

//类的继承：所有类都有一个父类 Any
private open class Base {
    open fun v() {}
    fun nv() {}

    constructor()
    constructor(p: Int)
}

//必须初始化父类
private class Derived(p: Int) : Base(p) {
    // 方法重写
    override fun v() {}
}

private open class AnotherDerived() : Base() {
    // 使用final防止子类重写
    final override fun v() {}
}

// 属性重写，可以在子类中定义 var类型覆盖父类val，反之则不可以
private open class Foo {
    open val x: Int
        get() {
            TODO()
        }
    open var y: Int? = null
    open fun f() {}
}

private class Bar1 : Foo() {
    override var x: Int = 0
    override var y: Int? = null
//    override val y: Int?= null  //Error
}

/*
vice versa	英[ˌvaɪs ˈvɜ:sə]
美[ˌvaɪs ˈvɜ:rsə]
adv.	反之亦然; 反过来也一样;
 */
// 在  primary constructor中也可以使用override
private interface FooBase {
    val count: Int
    var amount: String
}

private class Bar2(override val count: Int, override var amount: String) : FooBase
private class Bar3 : FooBase {
    override val count: Int = 0
    override var amount: String = ""
}
// 使用super调用父类方法

// inner类中使用 super@外部类名 访问外部类
private class Bar4 : Foo() {
    override fun f() {}
    override val x: Int
        get() = 0

    inner class Baz {
        fun g() {
            super@Bar4.f()
            println(super@Bar4.x)
        }
    }

    class BazNoInner {
        fun g() {
            Bar4().f()
            println(Bar4().x)
        }
    }
}

// 重写规则，如果一个类继承了多个含有相同成员的父类，则此类必须重写成员，为了指示父类，可以使用 super<父类名>
private open class A {
    open fun f() {
        println("A")
    }

    fun a() {
        println("a")
    }
}

private interface B {
    fun f() {
        println("B")
    }

    fun b() {
        println("b")
    }
}

private class C : A(), B {
    override fun f() {
        println("C.f()")
        super<A>.f()
        super<B>.f()
    }
}

// *********抽象类
private abstract class DerivedBase : Base() {
    override fun v() {
    }
}

//val baz: Int = 7