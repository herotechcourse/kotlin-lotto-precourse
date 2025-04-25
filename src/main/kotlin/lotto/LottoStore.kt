package lotto

class LottoStore(val lottoGenerator: LottoGenerator) {

    fun generateLottoTickets(quantity: Int): List<Lotto> {
        return List(quantity) { lottoGenerator.generate() }
    }
}
