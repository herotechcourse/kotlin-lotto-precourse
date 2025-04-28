package lotto

object OutputView {

    const val ASK_FOR_PURCHASE_AMOUNT = "Please enter the purchase amount."
    const val ASK_FOR_WINNING_NUMBERS = "Please enter last week's winning numbers."
    const val ASK_FOR_BONUS_NUMBER = "\nPlease enter the bonus number."

    fun askForPurchaseAmount() {
        println(ASK_FOR_PURCHASE_AMOUNT)
        InputView.getPurchaseAmount()
    }

    fun askForWinningNumbers() {
        println(ASK_FOR_WINNING_NUMBERS)
        InputView.getWinningNumbers()
    }

    fun askForBonusNumber() {
        println(ASK_FOR_BONUS_NUMBER)
        InputView.getBonusNumber()
    }

    fun printTickets(tickets: List<List<Int>>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println("[${ticket.joinToString(", ")}]")
        }
        println()
    }

    fun printWinnings(winnings: Map<PrizeRank, Int>, ranks: List<PrizeRank>) {
        println("\nWinning Statistics\n---")
        for (rank in ranks) {
            print("${rank.matches} Matches ")
            if (rank.bonusNumber) {
                print("+ Bonus Ball ")
            }
            println("(${rank.prize}) – ${winnings.getValue(rank)} tickets")
        }
        println("Total return rate is ${LotteryTicketMachine.returnRate}%.")
    }
}