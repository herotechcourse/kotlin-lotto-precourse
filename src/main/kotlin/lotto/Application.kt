package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = InputView.inputPurchaseAmount()
    val lottoMachine = LottoMachine(amount)
    lottoMachine.purchaseLottoTicket(amount)
    OutputView.printTickets(lottoMachine.tickets)
    val winningNumbers = InputView.inputLottoNumber()
    val bonusNumber = InputView.inputBonusNumber(winningNumbers)
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val rankCounts = lottoMachine.calculateResults(lottoMachine.tickets, winningLotto)
    val totalPrize = rankCounts.entries.sumOf { it.key.prizeMoney * it.value }
    val profitRate = (totalPrize.toDouble() / amount) * 100
    OutputView.printResultStatistics(rankCounts)
    OutputView.printProfitRate(profitRate)
}

enum class ResultRank(
    val matchCount: Int,
    val prizeMoney: Int,
    private val bonusRequired: Boolean = false
) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000),
    NO_WIN(0, 0);

    val bonusText: String
        get() = if (bonusRequired) " + Bonus Ball" else ""
}

class LottoMachine (purchaseAmount: Int) {

    val tickets: MutableList<Lotto> = mutableListOf()

    init {
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than zero." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000."}
    }

    fun purchaseLottoTicket(purchaseAmount: Int) {
        val ticketQuantity = purchaseAmount / 1000
        repeat (ticketQuantity) {
            val lotto = Lotto(generateTicketNumbers())
            tickets.add(lotto)
        }
    }

    private fun generateTicketNumbers(): List<Int> {
        val ticketNumbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return ticketNumbers
    }

    fun calculateResults(tickets: List<Lotto>, winningLotto: WinningLotto): Map<ResultRank, Int> {
        val rankCounts = mutableMapOf<ResultRank, Int>()

        tickets.forEach { ticket ->
            val rank = winningLotto.match(ticket)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1

        }
        return rankCounts
    }
}