package lotto.model

import lotto.Lotto
import lotto.model.random.RandomNumbersGenerator

class LottoMachine(private val randomNumbersGenerator: RandomNumbersGenerator) {
    fun makeLottos(purchaseAmount: Int): List<Lotto> {
        val countOfLottos = calculateCountOfLottos(purchaseAmount)
        val lottos: MutableList<Lotto> = mutableListOf()
        repeat(countOfLottos) {
            val randomLottoNumbers = randomNumbersGenerator.generate()
            val randomLotto = Lotto(randomLottoNumbers)
            lottos.add(randomLotto)
        }
        return lottos
    }

    private fun calculateCountOfLottos(purchaseAmount: Int): Int {
        return purchaseAmount / PRICE_OF_LOTTO
    }

    companion object {
        private const val PRICE_OF_LOTTO = 1000
    }
}
