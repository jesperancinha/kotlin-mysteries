package org.jesperancinha.talks.carparts.carpartsdatascructures.service

import jakarta.transaction.Transactional
import org.jesperancinha.talks.carparts.carpartsdatascructures.converter.toDto
import org.jesperancinha.talks.carparts.carpartsdatascructures.converter.toEntity
import org.jesperancinha.talks.carparts.carpartsdatascructures.domain.CarPartDao
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.springframework.stereotype.Service

@Service
class CarPartsService(
    val carPartDao: CarPartDao
) {
    @Transactional
    fun createCarPart(carPartDto: CarPartDto) = carPartDao.save(carPartDto.toEntity()).toDto()

    fun upsertCarPart(carPartDto: CarPartDto) = carPartDao.save(carPartDto.toEntity()).toDto()
    fun getCarParts(): List<CarPartDto> = carPartDao.findAll().mapNotNull { it.toDto() }
}

