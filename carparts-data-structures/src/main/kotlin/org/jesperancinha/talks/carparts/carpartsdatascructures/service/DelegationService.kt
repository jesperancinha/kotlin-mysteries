package org.jesperancinha.talks.carparts.org.jesperancinha.talks.carparts.carpartsdatascructures.service

import jakarta.validation.constraints.Past
import org.jesperancinha.talks.carparts.LocalDateTimeDelegate
import org.jesperancinha.talks.carparts.org.jesperancinha.talks.carparts.carpartsdatascructures.converter.LocalDateTimeValidatorConstraint
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
data class DelegationService(
    val id: UUID = UUID.randomUUID()
) {
    @delegate:LocalDateTimeValidatorConstraint
    @get: Past
    val currentDate: LocalDateTime by LocalDateTimeDelegate()
}