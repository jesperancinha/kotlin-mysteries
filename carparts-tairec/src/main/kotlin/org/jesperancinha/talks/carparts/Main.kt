package org.jesperancinha.talks.carparts

sealed interface Part {
    val totalWeight: Double
}

sealed interface ComplexPart  : Part {
    val parts: List<Part>
}
data class CarPart(val name: String, val weight: Double) : Part {
    override val totalWeight: Double
        get() = weight
}

data class ComplexCarPart(
    val name: String,
    val weight: Double,
    override val parts: List<Part>
) :
    ComplexPart {
    override val totalWeight: Double
        get() = weight
}

data class Car(
    val name: String,
    override val parts: List<Part>
) : ComplexPart {
    override val totalWeight: Double
        get() = parts.sumOf { it.totalWeight }
}

tailrec fun totalWeight(parts: List<Part>, acc: Double = 0.0): Double {
    if (parts.isEmpty()) {
        return acc
    }
    val part = parts.first()
    val remainingParts = parts.drop(1)
    val currentWeight = acc + part.totalWeight
    return when (part) {
        is ComplexPart -> totalWeight(remainingParts + part.parts, currentWeight)
        else -> totalWeight(remainingParts, currentWeight)
    }
}

fun main() {
    val cars =
        listOf(
            Car(
                "Anna", listOf(
                    CarPart("Chassis", 50.0),
                    CarPart("Engine", 100.0),
                    CarPart("Transmission", 150.0),
                    ComplexCarPart(
                        "Frame", 500.0,
                        listOf(
                            CarPart("Screw", 1.0),
                            CarPart("Screw", 2.0),
                            CarPart("Screw", 3.0),
                            CarPart("Screw", 4.0),
                        )
                    ),
                    CarPart("Suspension", 200.0),
                    CarPart("Wheels", 100.0),
                    CarPart("Seats", 50.0),
                    CarPart("Dashboard", 30.0),
                    CarPart("Airbags", 20.0)
                )
            ),
            Car(
                "George", listOf(
                    ComplexCarPart(
                        "Chassis", 300.0,
                        listOf(
                            CarPart("Screw", 1.0),
                            CarPart("Screw", 2.0),
                            CarPart("Screw", 3.0),
                            CarPart("Screw", 4.0),
                        )
                    ),
                    CarPart("Engine", 300.0),
                    CarPart("Transmission", 150.0),
                    CarPart("Seats", 50.0),
                    CarPart("Dashboard", 30.0),
                    CarPart("Airbags", 20.0)
                )
            )
        )

    val total = totalWeight(cars)
    println("Total weight of ${cars.size} is $total kg")
}
