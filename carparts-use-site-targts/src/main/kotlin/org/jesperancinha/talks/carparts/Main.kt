package org.jesperancinha.talks.carparts


val carpartName by lazy { "Breaks" }
fun main() {
    println(carpartName)
    val animal = Animal()
    animal.wagonHorn.beep()
    animal.carHorn.beep()
}
