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

annotation class DelegateToWagonHorn

annotation class DelegateToCarHorn

class SoundDelegate(private val initialHorn: Horn) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Horn {
        return initialHorn
    }
}

class HornPack {
    @delegate:DelegateToWagonHorn
    val wagonHorn: Horn by SoundDelegate(CarHorn())

    @delegate:DelegateToCarHorn
    val carHorn: Horn by SoundDelegate(WagonHorn())
}
