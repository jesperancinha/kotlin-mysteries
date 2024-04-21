package org.jesperancinha.talks.carparts

class SpecialShopNonLocalReturn {

    companion object {
        inline fun someFunction(block: () -> Unit) {
            block()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            someFunction {
                println("Inside lambda")
                return@main
            }
            println("This line will not be reached!")
        }
    }
}


class SpecialShopLocalReturn {

    companion object {
        inline fun someFunction(crossinline block: () -> Unit) {
            block()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            someFunction {
                println("Inside lambda")
                return@someFunction
            }
            println("This line will be reached")
        }
    }
}

