package lotto.domain

import lotto.controller.ValidatedResult
import lotto.util.ErrorReasonBuilder

class WinningNumbers(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { "Winning numbers must be 6 numbers." }
    }

    fun toList(): List<Int> {
        return numbers.map { it.value }
    }

    fun contains(value: Int): Boolean {
        return numbers.contains(LottoNumber(value))
    }

    fun contains(value: LottoNumber): Boolean {
        return numbers.contains(value)
    }

    companion object {
        private const val MUST_BE_UNIQUE = "Winning numbers must be unique."
        private const val LOTTO_COUNT = 6
        private const val NOT_EXACTLY_LENGTH = "Winning number must be exactly $LOTTO_COUNT numbers."

        fun validate(raw: List<String>): ValidatedResult<WinningNumbers> {
            val builder = ErrorReasonBuilder()

            builder.require(raw.size == LOTTO_COUNT, NOT_EXACTLY_LENGTH)
            builder.require(raw.distinct().size == raw.size, MUST_BE_UNIQUE)

            if (builder.inEmpty()) return ValidatedResult.Success(WinningNumbers(raw.map { LottoNumber(it.toInt()) }.toSet()))
            return ValidatedResult.Failure(builder.getReasons())
        }

        fun of(numbers: List<Int>): WinningNumbers {

            return WinningNumbers(
                numbers.map { LottoNumber(it) }.toSet()
            )
        }
    }
}
