package org.jesperancinha.talks.carparts.carpartsdatascructures.controller

import jakarta.validation.Valid
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsdatascructures.service.CarPartsService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class CarPartsController(
    val carPartsService: CarPartsService
) {
    @PostMapping("create")
    fun createCarPart(@RequestBody @Valid carPartDto: CarPartDto) = carPartsService.createCarPart(carPartDto)

    @PutMapping("upsert")
    fun upsert(@RequestBody @Valid carPartDto: CarPartDto) = carPartsService.upsertCarPart(carPartDto)

    @GetMapping
    fun getCarParts() = carPartsService.getCarParts()
}