package lotto

fun main() {
    var inputView = InputView()
    inputView.initPrintTicket()

    var prize: Int = 0
    var prizeRankList: MutableList<Prize> = mutableListOf()

    // create lotto instance for each ticket, determine the prize rank
    for (ticket in inputView.getTickets()) {
        val lotto = Lotto(ticket)
        var prizeRank = lotto.findMatches(inputView.getWinningNumbers(), inputView.getBonusNumber())
        prizeRankList.add(prizeRank)
        prize += prizeRank.prizeMoney
    }
    Lotto.calculatePrintPrize(prizeRankList, prize, inputView.getPurchaseAmount())
}

