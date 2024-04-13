package org.jesperancinha.talks.carparts.carpartsmanager.constroller

import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsmanager.service.CarPartsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping
class CarPartsController(
    val carPartsService: CarPartsService
) {
    @PostMapping("create")
    fun createCarPart(@RequestBody carPartDto: CarPartDto) = carPartsService.createCarPart(carPartDto)

    @PutMapping("upsert")
    fun upsert(@RequestBody carPartDto: CarPartDto) = carPartsService.upsertCarPart(carPartDto)
}