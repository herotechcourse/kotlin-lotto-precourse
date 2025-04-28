package lotto

fun main() {
    try {
        val purchase = InputView.readPurchaseAmount()
        val machine  = LottoMachine()
        val tickets  = machine.issue(purchase)

        OutputView.printTickets(tickets)

        val winningLotto = InputView.readWinningNumbers()
        val bonus        = InputView.readBonusNumber()
        val winningNums  = WinningNumbers(winningLotto, bonus)

        // compare & tally
        val stats      = tickets.fold(ResultStatistics()) { acc, ticket ->
            val matches = ticket.countMatch(winningNums.winningNumbers)
            val rank = Rank.values().firstOrNull {
                it.matchCount == matches &&
                (!it.requiresBonus || ticket.hasNumber(winningNums.bonusNumber))
            }
            if (rank != null) acc.increment(rank)
            acc
        }

        OutputView.printStatistics(stats, purchase)

    } catch (e: IllegalArgumentException) {
        println(e.message)
        main()  // re-prompt from the failing step
    }
}
