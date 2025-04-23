package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generate(ticketCount: Int) : Lottos {
        val generatedLottos = mutableListOf<Lotto>()
        repeat(ticketCount) {
            val generatedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_NUMBER)
            generatedLottos.add(Lotto(generatedNumbers))
        }
        return Lottos(generatedLottos)
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val PICK_NUMBER = 6
    }
}