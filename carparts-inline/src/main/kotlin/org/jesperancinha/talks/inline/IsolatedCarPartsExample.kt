package org.jesperancinha.talks.inline

import java.time.LocalDateTime

fun main() {
    callEngineCrossInline {
        println("Place key in ignition")
        println("Turn key or press push button ignition")
        println("Clutch to the floor")
        println("Set the first gear")
    }.run { println(this) }
}

inline fun callEngineCrossInline(crossinline startManually: () -> Unit) {
    run loop@{
        println("This is the start of the loop.")
        introduction {
            println("Get computer in the backseat")
            startManually()
            return@introduction
        }
        println("This is the end of the loop.")
    }
    println("Engine started!")
}

fun introduction(intro: () -> Unit) {
    println(LocalDateTime.now())
    intro()
    return
}
