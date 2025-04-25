package lotto

import camp.nextstep.edu.missionutils.Randoms

class LotteryGame {
    fun generateAllTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount/1000
        return List(ticketCount) {generateLotteryTicket()}
    }

    companion object {
        private fun generateLotteryTicket(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers)
        }
    }
}