package lotto


class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun generate(ticketCount: Int) : Lottos {
        val generatedLottos = mutableListOf<Lotto>()
        repeat(ticketCount) {
            val generatedNumbers = lottoNumberGenerator.generateNumbers()
            generatedLottos.add(Lotto(generatedNumbers))
        }
        return Lottos(generatedLottos)
    }
}