package org.jesperancinha.talks.carparts


val carpartName by lazy { "Breaks" }
fun main() {
    println(carpartName)
    val hornPack = HornPack()
    hornPack.wagonHorn.beep()
    hornPack.carHorn.beep()
}
