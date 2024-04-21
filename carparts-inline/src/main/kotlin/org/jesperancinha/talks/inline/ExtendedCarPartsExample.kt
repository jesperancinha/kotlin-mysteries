package org.jesperancinha.talks.inline

import java.time.LocalDateTime

object ExtendedCarPartsExample {
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
        }.run { println(this) }
    }

    inline fun callEngineCrossInline(crossinline startManually: () -> Unit) {
        run loop@{
            for (i in 1..100) {
                (1..10).forEach { subI ->
                    println("Just one time! $i - $subI")
                    return@loop
                }
            }
        }
        run loop@{
            println("This is the start of the loop.")
            introduction {
                println("Get computer in the backseat")
                startManually()
                return@introduction
            }
            println("This is the end of the loop.")
        }


        introduction {
            startManually()
        }
        println("Engine started!")
    }

    fun introduction(intro: () -> Unit) {
        println(LocalDateTime.now())
        intro()
        return
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
}