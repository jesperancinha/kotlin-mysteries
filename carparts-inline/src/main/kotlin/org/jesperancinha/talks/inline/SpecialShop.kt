package org.jesperancinha.talks.inline

object SpecialShopNonLocalReturn {

    inline fun goToStore(chooseItems: () -> Unit) {
        println("Walks in")
        chooseItems()
    }

    @JvmStatic
    fun main(args: Array<String> = emptyArray()) {
        goToStore {
            println("Make purchase")
            return@main
        }
        println("Never walks out")
    }
}


object SpecialShopLocalReturn {
    inline fun goToStore(crossinline block: () -> Unit) {
        println("Walks in")
        block()
    }

    @JvmStatic
    fun main(args: Array<String> = emptyArray()) {
        goToStore {
            println("Make purchase")
            return@goToStore
        }
        println("Walks out")
    }
}

