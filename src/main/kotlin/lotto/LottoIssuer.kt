package lotto

class LottoIssuer {

    fun issueLottos(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000

        return List(ticketCount) { Lotto.generateRandomLotto() }
    }
}