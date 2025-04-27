package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6

        fun generateLottoList(purchaseAmount: PurchaseAmount): List<Lotto> {
            return List(purchaseAmount.ticketCount) {
                val randomNumbers = generate6UniqueNumbers()
                val orderedNumbers = sortInAscendingOrder(randomNumbers)
                Lotto(numbers = orderedNumbers)
            }
        }

        private fun generate6UniqueNumbers(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE)
        }

        private fun sortInAscendingOrder(numbers: List<Int>): List<Int> {
            return numbers.sorted()
        }
    }
}
