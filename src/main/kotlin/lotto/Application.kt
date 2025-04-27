package lotto

fun main() {
    val inputView = InputView().apply { initPrintTicket() }
    val prizeRankList: MutableList<Prize> = mutableListOf()
    inputView.tickets.forEach {
        var prizeRank = Lotto(it).findPrizeRank(inputView.winningNumbers, inputView.bonusNumber)
        prizeRankList.add(prizeRank)
    }
    Lotto.calculatePrintPrize(prizeRankList, inputView.purchaseAmount)
}