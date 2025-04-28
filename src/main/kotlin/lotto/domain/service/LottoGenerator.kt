package lotto.domain.service

import lotto.config.NumberGenerator
import lotto.domain.model.Lotties
import lotto.Lotto


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