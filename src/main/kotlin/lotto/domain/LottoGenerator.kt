package lotto.domain

import lotto.NumberGenerator


class LottoGenerator(private val numberGenerator: NumberGenerator) {

    fun generateLotties(ticketCount: Int): Lotties {
        val lotties = mutableListOf<Lotto>()
        for (i in 1..ticketCount) {
            lotties.add(generateLotto(numberGenerator.generate()))
        }
        return Lotties(lotties)
    }

    private fun generateLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers)
    }
}