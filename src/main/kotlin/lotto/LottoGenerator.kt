package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    fun generate(count: Int): List<Lotto> {
        return List(count) {
            Lotto(generateSingleTicket())
        }
    }

    private fun generateSingleTicket(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}