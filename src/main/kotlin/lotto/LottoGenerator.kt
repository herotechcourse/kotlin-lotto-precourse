package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoPrice

object LottoGenerator {
    private const val LOTTO_SIZE = 6
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45

    fun generate(amount: Int): List<Lotto> {
        val count: Int = amount / LottoPrice.TICKET
        val lottos: List<Lotto> = List(count) { generateLotto() }

        return lottos
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
        return Lotto(numbers)
    }
}