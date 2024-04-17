package org.jesperancinha.talks.carparts

import java.time.LocalDateTime

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
    callEngineCrossInline {
        println("Place key in ignition")
        println("Turn key or press pus button ignition")
        println("Clutch to the floor")
        println("Set the first gear")
        true
    }.run { println(this) }
}

inline fun callEngineCrossInline(crossinline startManually: () -> Boolean): Boolean {
    run loop@{
        for (i in 1..100) {
            (1..10).forEach { subI ->
                println("Just one time! $i - $subI")
                return@loop;
            }
        }
    }
    val introductionResult = run loop@{
        val test = introduction {
            println("Get computer in the backseat")
            return@introduction startManually()
        }
        test
    }
    println("Engine started!")
    return introductionResult
}

inline fun introduction(intro: () -> Boolean): Boolean {
    println(LocalDateTime.now())
    intro()
    return true
}

fun callEngine() {
    println("Engine started!")
}

inline fun <reified T> callACopyOfAnEngine(value: T) {
    println("Copy of an engine started!")
    println(value)
}

inline fun cleanGlass(f: () -> Unit) {
    f()
}