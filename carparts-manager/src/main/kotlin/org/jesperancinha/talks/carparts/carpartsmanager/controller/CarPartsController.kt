package org.jesperancinha.talks.carparts.carpartsmanager.controller

import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsmanager.service.CarPartsService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class CarPartsController(
    val carPartsService: CarPartsService
) {
    @PostMapping("create")
    fun createCarPart(@RequestBody carPartDto: CarPartDto) = carPartsService.createCarPart(carPartDto)

    @PutMapping("upsert")
    fun upsert(@RequestBody carPartDto: CarPartDto) = carPartsService.upsertCarPart(carPartDto)

    @GetMapping
    fun getCarParts() = carPartsService.getCarParts()
}