package lotto

class LottoMachine {

    fun issueLottos(purchaseAmount: Int): List<Lotto> {
        require(purchaseAmount >= 1000 && purchaseAmount % 1000 == 0) {
            "[ERROR] Purchase amount must be a multiple of 1,000."
        }

        val ticketCount = purchaseAmount / 1000

        return List(ticketCount) { Lotto.generateRandomLotto() }
    }
}