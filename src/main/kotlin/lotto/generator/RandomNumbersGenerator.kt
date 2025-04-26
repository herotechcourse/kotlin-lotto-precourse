package lotto.generator

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE

class RandomNumbersGenerator {

    fun generate(): List<Int> {
        val numbersInRange = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)

        require(numbersInRange.size == numbersInRange.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        for (number in numbersInRange) {
            require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] Lotto number $number is out of the valid range (${START_INCLUSIVE}–${END_INCLUSIVE})." }
        }

        return numbersInRange
    }

}