package lotto.validators

interface InputValidator<T> {
    @Throws(IllegalArgumentException::class) 
    fun validate(input: String): T
}
