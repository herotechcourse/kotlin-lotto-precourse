package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) {"Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER."}
    }

    companion object {
        const val MIN_NUMBER: Int = 1
        const val MAX_NUMBER: Int = 45
    }
}
