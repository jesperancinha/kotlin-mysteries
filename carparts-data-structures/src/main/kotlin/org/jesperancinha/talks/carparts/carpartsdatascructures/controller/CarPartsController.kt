package org.jesperancinha.talks.carparts.carpartsdatascructures.controller

import ImpossiblePartNameDto
import PartNameDto
import jakarta.validation.Valid
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsdatascructures.service.CarPartsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class CarPartsController(
    val carPartsService: CarPartsService,
    @field:Qualifier("carPartServiceExtended")
    val carPartServiceExtended: CarPartsService
) {
    @PostMapping("create")
    fun createCarPart(@RequestBody @Valid carPartDto: CarPartDto) = carPartsService.createCarPart(carPartDto)

    @PutMapping("upsert")
    fun upsert(@RequestBody @Valid carPartDto: CarPartDto) = carPartsService.upsertCarPart(carPartDto)

    @GetMapping
    fun getCarParts() = carPartServiceExtended.getCarParts()

    @PostMapping("create/extended")
    fun createCarPartExtended(@RequestBody @Valid carPartDto: CarPartDto) = carPartServiceExtended.createCarPart(carPartDto)

    @PutMapping("upsert/extended")
    fun upsertExtended(@RequestBody @Valid carPartDto: CarPartDto) = carPartServiceExtended.upsertCarPart(carPartDto)

    @GetMapping("extended")
    fun getCarPartsExtended() = carPartServiceExtended.getCarParts()

    @PostMapping("name")
    fun createName(@RequestBody @Valid partNameDto: PartNameDto){
        println(partNameDto)
    }

    @PostMapping("impossible")
    fun createImpossibleName(@RequestBody @Valid partNameDto: ImpossiblePartNameDto){
        println(partNameDto)
    }
}