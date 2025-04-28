package lotto

import lotto.domain.LottoConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.Ticket.SIZE) {
            "[ERROR] Lotto must contain exactly 6 numbers."
        }
        require(numbers.size == numbers.distinct().count()) {
            "[ERROR] Lotto Numbers must be unique."
        }
        require(
                numbers.all { it in LottoConstants.NumberRange.MIN..LottoConstants.NumberRange.MAX }
        ) {
            "[ERROR] Lotto Numbers must be between ${LottoConstants.NumberRange.MIN} and ${LottoConstants.NumberRange.MAX}."
        }
    }

    // TODO: Implement additional functions
    val getNumbers: List<Int>
        get() = numbers.toList()
}
