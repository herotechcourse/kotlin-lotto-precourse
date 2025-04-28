package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { generateSingleLotto() }
    }

    private fun generateSingleLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()
        return Lotto(numbers)
    }
}