package lotto


class LottoGenerator(private val numberGenerator: NumberGenerator) {

    fun generateLotties(money: Money): Lotties {
        val lotties = mutableListOf<Lotto>()
        for (i in 1..money.ticketCount) {
            lotties.add(generateLotto(numberGenerator.generate()))
        }
        return Lotties(lotties)
    }

    private fun generateLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers)
    }
}