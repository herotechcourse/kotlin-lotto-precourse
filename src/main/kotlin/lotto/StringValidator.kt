package lotto

object StringValidator {

    private const val COMMA = ","

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("Non-numeric '$stringValue' is not allowed.")
    }

    fun validateStringToIntList(stringValue: String) =
        stringValue.split(COMMA).map { validateStringToInt(it) }
}
