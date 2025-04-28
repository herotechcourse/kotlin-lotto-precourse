package lotto.domain

@JvmInline
value class LottoNumber(private val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) {"[ERR] Lotto number must in a range 1~45."}
    }

    companion object {
        const val MIN_NUMBER: Int = 1
        const val MAX_NUMBER: Int = 45
    }
}
