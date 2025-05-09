package lotto.domain

import lotto.controller.ValidatedResult
import lotto.util.CommonMessages
import lotto.util.ErrorReasonBuilder

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { EXCEED_LOTTO_NUMBER }
    }

    companion object {
        const val MIN_NUMBER: Int = 1
        const val MAX_NUMBER: Int = 45
        const val EXCEED_LOTTO_NUMBER = "Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER"

        fun validate(raw: String): ValidatedResult<LottoNumber> {
            val builder = ErrorReasonBuilder()

            val number = raw.toIntOrNull()

            builder.require(number != null, CommonMessages.INVALID_NUMBER_FORMAT)
            builder.require(number in MIN_NUMBER..MAX_NUMBER, EXCEED_LOTTO_NUMBER)

            if (builder.inEmpty()) return ValidatedResult.Success(LottoNumber(number!!))
            return ValidatedResult.Failure(builder.getReasons())
        }
    }
}
