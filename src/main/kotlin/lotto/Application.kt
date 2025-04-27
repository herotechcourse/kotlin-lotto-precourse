package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = InputView.inputPurchaseAmount()
    val lottoMachine = LottoMachine(amount)
    lottoMachine.purchaseLottoTicket(amount)
    OutputView.printTickets(lottoMachine.tickets)

    val winningNumbers = InputView.inputLottoNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val rankCounts = mutableMapOf<ResultRank, Int>()

    for (ticket in lottoMachine.tickets) {
        val rank = winningLotto.match(ticket)
        rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
    }

    val totalPrize = rankCounts.entries.sumOf { it.key.prizeMoney * it.value }
    val profitRate = (totalPrize.toDouble() / amount) * 100

    OutputView.printResultStatistics(rankCounts)
    OutputView.printProfitRate(profitRate)
}

enum class ResultRank(val matchCount: Int, val prizeMoney: Int, val requiresBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): ResultRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}


object InputView {
    fun inputPurchaseAmount():Int {
        println("Please enter the purchase amount.")
        val purchaseAmount = Console.readLine().toInt()
        return purchaseAmount
    }

    fun inputLottoNumber():List<Int> {
        println()
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine().removeWhiteSpaces().split(",").map { it.toInt() }
        return winningNumbers
    }

    private fun String.removeWhiteSpaces() = replace("\\s".toRegex(), "")

    fun inputBonusNumber():Int {
        println()
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

    fun printResultStatistics(rankCounts: Map<ResultRank, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        ResultRank.entries.filter { it != ResultRank.NONE }.forEach { rank ->
                val count = rankCounts.getOrDefault(rank, 0)
                println("${rank.matchCount} Matches${if (rank.requiresBonus) " + Bonus Ball" else ""} (${rank.prizeMoney} KRW) - $count tickets")
            }
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

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int)
{
    fun match(ticket: Lotto): ResultRank {
        val matchCount = ticket.matchNumbers(winningNumbers)
        val containsBonus = ticket.getNumbers().contains(bonusNumber)
        return ResultRank.of(matchCount, containsBonus)
    }
}