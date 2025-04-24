package lotto.model

import lotto.Lotto

class LottoManager(val winnerLotto: Lotto, val user: User) {
    val matchedLottoTicket: MutableList<Int> = MutableList(6) { 0 }
    var winningRate: Float = 0f

    init {
        matchAndPaySettlement()
    }

    private fun getLottoRank(lotto: Lotto): Int {
        val matches: Int = lotto.numbers.count { it in winnerLotto.numbers }
        val isBonus: Boolean = winnerLotto.bonusNumber in lotto.numbers
        return when (matches) {
            6 -> 1
            5 -> if (isBonus) 2 else 3
            4 -> 4
            3 -> 5
            else -> 0
        }
    }

    private fun matchLotto() {
        user.lottoTickets.forEach { matchedLottoTicket[getLottoRank(it)] += 1 }
    }

    private fun paySettlementAmount() {
        matchedLottoTicket.forEachIndexed { index, num ->
            when (index) {
                1 -> user.earnedAmount += FIRST_PRIZE * num
                2 -> user.earnedAmount += SECOND_PRIZE * num
                3 -> user.earnedAmount += THIRD_PRIZE * num
                4 -> user.earnedAmount += FORTH_PRIZE * num
                5 -> user.earnedAmount += FIFTH_PRIZE * num
                else -> return@forEachIndexed
            }
        }
    }

    private fun getWinningRate() {
        val rate = (user.earnedAmount.toFloat() / user.usedAmount) * 100
//        println("${user.earnedAmount},  ${user.usedAmount}")
        winningRate = (Math.round(rate * 10) / 10f)
    }

    private fun matchAndPaySettlement() {
        matchLotto()
        paySettlementAmount()
        getWinningRate()
    }


    companion object {
        const val FIRST_PRIZE = 2_000_000_000
        const val SECOND_PRIZE = 30_000_000
        const val THIRD_PRIZE = 1_500_000
        const val FORTH_PRIZE = 50_000
        const val FIFTH_PRIZE = 5_000

    }

}