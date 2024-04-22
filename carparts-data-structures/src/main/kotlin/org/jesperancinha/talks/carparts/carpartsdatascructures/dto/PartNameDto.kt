import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlin.reflect.KProperty

class SanitizedName(var name: String?) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? = name
    operator fun setValue(thisRef: Any?, property: KProperty<*>, v: String?) {
        name = v?.trim()
    }
}


class PartNameDto {
    @get:NotBlank
    @get:Size(max = 12)
    var name: String? by SanitizedName(null)
    override fun toString(): String {
        return name ?: "N/A"
    }
}

class ImpossiblePartNameDto {
    @delegate:NotBlank
    @delegate:Size(max = 12)
    var name: String? by SanitizedName(null)
    override fun toString(): String {
        return name ?: "N/A"
    }
}