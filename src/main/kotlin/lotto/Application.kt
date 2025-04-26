package lotto

fun determinePrizes(tickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int): MutableList<Prize> {
    var prizeRankList: MutableList<Prize> = mutableListOf()
    for (ticket in tickets) {
        val lotto = Lotto(ticket)
        var prizeRank = lotto.findMatches(winningNumbers, bonusNumber)
        prizeRankList.add(prizeRank)
    }
    return prizeRankList
}

fun main() {
    val inputView = InputView().apply { initPrintTicket() }
    val tickets = inputView.getTickets()
    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()
    val purchaseAmount = inputView.getPurchaseAmount()
    val prizeRankList = determinePrizes(tickets, winningNumbers, bonusNumber)
    val totalPrize = prizeRankList.sumOf { it.prizeMoney }
    Lotto.calculatePrintPrize(prizeRankList, totalPrize, purchaseAmount)
}
