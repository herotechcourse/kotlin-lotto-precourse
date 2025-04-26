package lotto

fun main() {
    var inputView = InputView()
    inputView.initPrintTicket()

    var prize: Int = 0
    var prizeRankList: MutableList<Prize> = mutableListOf()

    for (ticket in inputView.getTickets()) {
        val lotto = Lotto(ticket)
        var prizeNumber = lotto.findMatches(inputView.getWinningNumber(), inputView.getBonusNumber())
        prizeRankList.add(prizeNumber)
        prize += prizeNumber.prizeMoney
    }
    OutputView.printPrizeStatics(prizeRankList, prize, inputView.getPurchaseAmount())
}

