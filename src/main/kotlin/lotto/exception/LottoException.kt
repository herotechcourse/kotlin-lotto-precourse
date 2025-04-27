package lotto.exception

enum class LottoException(private val message: String) : ErrorCode {
    INVALID_LOTTO_NUMBERS("[ERROR] Lotto must contain exactly 6 numbers."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] Lotto numbers must not contain duplicates.");

    override fun getMessage(): String = message
}
