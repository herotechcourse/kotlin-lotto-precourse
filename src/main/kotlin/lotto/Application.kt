package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchaseAmount = InputValidator.getValidPurchaseAmount()
    val numberOfTickets = purchaseAmount / 1000
    println()
    println("You have purchased $numberOfTickets tickets.")

    val playerTickets = (1..numberOfTickets).map {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        Lotto(numbers)
    }

    OutputFormatter.printTicketNumbers(playerTickets)

    val lotteryNumbers = InputValidator.getValidLotteryNumbers()
    val winningTicket = Lotto(lotteryNumbers)
    val bonusNumber = InputValidator.getValidBonusNumber()

    val game = LottoGame(playerTickets, winningTicket, bonusNumber)
    game.play()

    val results = game.getResults()

    OutputFormatter.printLottoStatistics(results, game.getTotalWinnings(), purchaseAmount)
}
