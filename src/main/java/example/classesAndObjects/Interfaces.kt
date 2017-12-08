package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/7
 * @version 1.0
 * 接口
 */
private interface MyInterface {

    // 接口中可以定义抽象属性
    val prop: Int
    fun bar()
    fun foo() {
        // optional body
    }
}
// 实现接口
private class Child : MyInterface {
    override var prop: Int = 1
    
    override fun bar() {

    }
}

