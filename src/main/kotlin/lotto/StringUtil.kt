package lotto

object StringUtil {

    private const val COMMA = ","

    fun String.toIntList(validator: Validator) = split(COMMA).map {
        validator.validateStringToInt(it)
    }
}
