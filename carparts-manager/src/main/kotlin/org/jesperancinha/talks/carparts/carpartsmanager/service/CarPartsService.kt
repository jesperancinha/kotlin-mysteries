package org.jesperancinha.talks.carparts.carpartsmanager.service

import jakarta.transaction.Transactional
import org.jesperancinha.talks.carparts.carpartsmanager.converter.toEntity
import org.jesperancinha.talks.carparts.carpartsmanager.converter.toDto
import org.jesperancinha.talks.carparts.carpartsmanager.domain.CarPartDao
import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto
import org.springframework.stereotype.Service

@Service
class CarPartsService(
    val carPartDao: CarPartDao
) {
    @Transactional
    fun createCarPart(carPartDto: CarPartDto) = carPartDao.save(carPartDto.toEntity()).toDto()

    fun upsertCarPart(carPartDto: CarPartDto) = carPartDao.save(carPartDto.toEntity()).toDto()
}

