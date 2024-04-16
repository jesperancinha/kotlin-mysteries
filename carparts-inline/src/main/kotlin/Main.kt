package org.jesperancinha.talks.carparts

fun main() {
    callEngine()
    callACopyOfAnEngine(123)
    callACopyOfAnEngine("Whatever")
    cleanGlass {
        println("Glass cleaned!")
    }
    cleanGlass {
        println("Glass cleaned!")
    }
}

fun callEngine() {
    println("Engine started!")
}

inline fun <reified T> callACopyOfAnEngine(value: T) {
    println("Copy of an engine started!")
    println(value)
}

inline fun cleanGlass(f: () -> Unit){
    f()
}