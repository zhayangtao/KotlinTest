package example.classesAndObjects

/**
 * @author zhayangtao
 * @since 2017/12/11
 * @version 1.0
 * 枚举类
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// Initialization
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// 匿名类
enum class ProtocolState {
    WAITING {
        override fun signal(): ProtocolState {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    },
    TALKING {
        override fun signal(): ProtocolState {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    };
    abstract fun signal(): ProtocolState
}

// 使用枚举常量
fun main(args: Array<String>) {
    Direction.valueOf(value = "")
    val direction: Array<Direction> = Direction.values()
}

//
inline fun <reified T: Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}