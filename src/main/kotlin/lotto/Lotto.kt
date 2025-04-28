package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
    }

    companion object {
        fun generateTickets(purchaseAmount: Int): List<Lotto> {
            require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1000." }
            val ticketCount = purchaseAmount / 1000
            return List(ticketCount) {
                val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                Lotto(numbers)
            }
        }
    }
}
