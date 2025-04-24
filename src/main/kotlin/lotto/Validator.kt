package lotto

class Validator {

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("Non-numeric '$stringValue' is not allowed.")
    }
}
