package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGenerator {
    private const val START_INCLUSIVE = 1
    private const val END_INCLUSIVE = 45
    private const val COUNT = 6

    fun generate(amount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (i in 0..amount) {
            val sortedRandomLotto = pickSortedLotto()
            lottos.add(sortedRandomLotto)
        }
        return lottos.toList()
    }

    fun pickSortedLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)
        numbers.sort()

        return Lotto(numbers)
    }
}