package lotto

class Validator {

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("$ERROR_PREFIX Non-numeric '$stringValue' is not allowed.")
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
    }
}
