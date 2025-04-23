package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generate(ticketCount: Int) : Lottos {
        val generatedLottos = mutableListOf<Lotto>()
        for (i in 1..ticketCount) {
            val generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            generatedLottos.add(Lotto(generatedNumbers))
        }
        return Lottos(generatedLottos)
    }
}