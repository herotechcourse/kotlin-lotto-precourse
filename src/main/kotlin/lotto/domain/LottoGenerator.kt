package lotto.domain

import lotto.Lotto

class LottoGenerator(val lottoNumberGenerator: LottoNumberGenerator) {
    fun generate(count :Int): List<Lotto> = List(count) { Lotto(lottoNumberGenerator.generate())}
}