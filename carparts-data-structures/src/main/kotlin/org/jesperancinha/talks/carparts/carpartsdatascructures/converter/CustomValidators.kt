package org.jesperancinha.talks.carparts.org.jesperancinha.talks.carparts.carpartsdatascructures.converter

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.jesperancinha.talks.carparts.LocalDateTimeDelegate
import org.jesperancinha.talks.carparts.carpartsdatascructures.utils.getLogger
import org.slf4j.Logger
import java.util.*
import kotlin.reflect.KClass

object CustomValidators {
    val logger: Logger = getLogger<LocalDateTimeValidator>()
}


@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [LocalDateTimeValidator::class])
@MustBeDocumented
annotation class LocalDateTimeValidatorConstraint(
    val message: String = "Invalid value",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []
)

class LocalDateTimeValidator : ConstraintValidator<LocalDateTimeValidatorConstraint, LocalDateTimeDelegate> {
    override fun initialize(constraintAnnotation: LocalDateTimeValidatorConstraint) {
    }

    override fun isValid(value: LocalDateTimeDelegate, context: ConstraintValidatorContext): Boolean {
        val country = Locale.getDefault().country.trim()
        logger.info("Current country is {}", country)
        return when (country) {
            "", "NL", "US" -> true
            else -> false
        }
    }

    companion object {
        val logger: Logger = getLogger<LocalDateTimeValidator>()
    }
}
