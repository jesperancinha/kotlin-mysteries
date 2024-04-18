import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface Sound {
    fun makeSound()
}

class CatSound : Sound {
    override fun makeSound() {
        println("Meow!")
    }
}

class DogSound : Sound {
    override fun makeSound() {
        println("Woof!")
    }
}

annotation class DelegateToCat

annotation class DelegateToDog

class Animal {
    // Using the @delegate annotation to apply the CatSound delegate
    @delegate:DelegateToCat
    val catSound: Sound by AnimalSoundDelegate(CatSound())

    // Using the @delegate annotation to apply the DogSound delegate
    @delegate:DelegateToDog
    val dogSound: Sound by AnimalSoundDelegate(DogSound())
}

class AnimalSoundDelegate(private val initialSound: Sound) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Sound {
        return initialSound
    }
}

fun main() {
    val animal = Animal()
    animal.catSound.makeSound() // Output will be "Meow!"
    animal.dogSound.makeSound() // Output will be "Woof!"
}
