package org.jesperancinha.talks.carparts

import kotlin.reflect.KProperty

interface Horn {
    fun beep()
}

class CarHorn : Horn {
    override fun beep() {
        println("beep!")
    }
}

class WagonHorn : Horn {
    override fun beep() {
        println("bwooooooo!")
    }
}

annotation class DelegateToCat

annotation class DelegateToDog

class Animal {
    @delegate:DelegateToCat
    val wagonHorn: Horn by AnimalSoundDelegate(CarHorn())

    @delegate:DelegateToDog
    val carHorn: Horn by AnimalSoundDelegate(WagonHorn())
}

class AnimalSoundDelegate(private val initialHorn: Horn) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Horn {
        return initialHorn
    }
}

