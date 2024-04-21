package org.jesperancinha.talks.inline

object SpecialShopNonLocalReturn {

    inline fun someFunction(block: () -> Unit) {
        block()
    }

    @JvmStatic
    fun main(args: Array<String> = emptyArray()) {
        someFunction {
            println("Inside lambda")
            return@main
        }
        println("This line will not be reached!")
    }
}


object SpecialShopLocalReturn {
    inline fun someFunction(crossinline block: () -> Unit) {
        block()
    }

    @JvmStatic
    fun main(args: Array<String> = emptyArray()) {
        someFunction {
            println("Inside lambda")
            return@someFunction
        }
        println("This line will be reached")
    }
}

