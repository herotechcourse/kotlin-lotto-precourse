package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    var purchaseAmount: Int
    while (true) {
        try {
            purchaseAmount = inputView.getPurchaseAmount()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    val numberOfTickets = purchaseAmount / 1000
    val tickets = List(numberOfTickets) {
        LottoTicket(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
    outputView.displayPurchasedTickets(tickets)

    var winningNumbers: List<Int>
    while (true) {
        try {
            winningNumbers = inputView.getWinningNumbers()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    var bonusNumber: Int
    while (true) {
        try {
            bonusNumber = inputView.getBonusNumber(winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val results = mutableMapOf<Prize, Int>()

    tickets.forEach { ticket ->
        val prize = winningLotto.compare(ticket)
        results[prize] = (results[prize] ?: 0) + 1
    }

    outputView.displayWinningStatistics(results, purchaseAmount)
}