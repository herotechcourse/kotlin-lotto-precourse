package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = InputView.inputPurchaseAmount()
    //println(InputView.inputLottoNumber())
    //println(InputView.inputBonusNumber())

    val lottoMachine = LottoMachine(amount)
    lottoMachine.purchaseLottoTicket(amount)
    OutputView.printTickets(lottoMachine.tickets)
    //OutputView.printResultStatistics()
    //OutputView.printProfitRate(62.2)
}

enum class WinningRanks(val rank: String) {
    FIRST("3 Matches (5,000 KRW)"),
    SECOND("4 Matches (50,000 KRW)"),
    THIRD("5 Matches (1,500,000 KRW)"),
    FOURTH("5 Matches + Bonus Ball (30,000,000 KRW)"),
    FIFTH("6 Matches (2,000,000,000 KRW)");
}

object InputView {
    fun inputPurchaseAmount():Int {
        println("Please enter the purchase amount.")
        val purchaseAmount = Console.readLine().toInt()
        return purchaseAmount
    }

    fun inputLottoNumber():List<Int> {
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine().removeWhiteSpaces().split(",").map { it.toInt() }
        return winningNumbers
    }

    private fun String.removeWhiteSpaces() = replace("\\s".toRegex(), "")

    fun inputBonusNumber():Int {
        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine().toInt()
        return bonusNumber
    }
}

object OutputView {
    fun printTickets(lottoTickets: List<Lotto>) {
        println()
        println("You have purchased ${lottoTickets.size} tickets.")
        for (lotto in lottoTickets) {
            println(lotto.getNumbers().joinToString(prefix="[", postfix="]", separator = ", "))
        }
    }

    fun printResultStatistics() {
        println(WinningRanks.FIRST.rank)
        println(WinningRanks.SECOND.rank)
        println(WinningRanks.THIRD.rank)
        println(WinningRanks.FOURTH.rank)
        println(WinningRanks.FIFTH.rank)
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is $profitRate%.")
    }
}

class LottoMachine (purchaseAmount: Int) {

    val tickets: MutableList<Lotto> = mutableListOf()

    init {
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than zero." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000."}
    }

    fun purchaseLottoTicket(purchaseAmount: Int) {
        val ticketQuantity = purchaseAmount / 1000
        for (i in 1..ticketQuantity) {
            val lotto = Lotto(generateTicketNumbers())
            tickets.add(lotto)
        }
    }

    private fun generateTicketNumbers(): List<Int> {
        val ticketNumbers : List<Int>  =   Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return ticketNumbers
    }
}