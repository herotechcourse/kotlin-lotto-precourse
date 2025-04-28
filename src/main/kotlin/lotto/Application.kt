package lotto

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

object Constants {
    const val TICKET_PRICE = 1_000
    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
}
