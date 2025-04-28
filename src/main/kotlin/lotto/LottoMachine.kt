package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun generate(ticketCount: Int) : Lottos {
        val generatedLottos = mutableListOf<Lotto>()
        repeat(ticketCount) {
            val generatedNumbers = lottoNumberGenerator.generateNumbers()
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