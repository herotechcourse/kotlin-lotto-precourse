package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.Config

interface LottoGenerator {
    fun generateNumbers(): List<Int>
}

object RandomLottoGenerator: LottoGenerator {
    override fun generateNumbers(): List<Int> {
        val lottoLength = Config.LENGTH_OF_LOTTO
        val minNumber = Config.MIN_LOTTO_NUMBER
        val maxNumber = Config.MAX_LOTTO_NUMBER

        val numbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoLength)
        return numbers.sorted()
    }
}