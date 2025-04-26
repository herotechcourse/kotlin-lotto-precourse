package lotto.generator

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

class FixedNumbersGenerator(val numbers: List<Int>): NumbersGenerator {

    init {
        require(numbers.size == COUNT) { "[ERROR] Lotto numbers size must be $COUNT." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        for (number in numbers) {
            require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] Lotto number $number is out of the valid range (${START_INCLUSIVE}–$END_INCLUSIVE)." }
        }
    }

    override fun generate(): List<Int> {
        return numbers
    }

}