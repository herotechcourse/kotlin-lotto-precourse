package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = InputView.inputPurchaseAmount()
    val lottoMachine = LottoMachine(amount)
    lottoMachine.purchaseLottoTicket(amount)
    OutputView.printTickets(lottoMachine.tickets)

    val winningNumbers = InputView.inputLottoNumber()
    val bonusNumber = InputView.inputBonusNumber(winningNumbers)
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val rankCounts = lottoMachine.calculateResults(lottoMachine.tickets, winningLotto)
    val totalPrize = rankCounts.entries.sumOf { it.key.prizeMoney * it.value }
    val profitRate = (totalPrize.toDouble() / amount) * 100

    OutputView.printResultStatistics(rankCounts)
    OutputView.printProfitRate(profitRate)
}

enum class ResultRank(
    val matchCount: Int,
    val prizeMoney: Int,
    private val bonusRequired: Boolean = false
) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000),
    NO_WIN(0, 0);

    val bonusText: String
        get() = if (bonusRequired) " + Bonus Ball" else ""
}

object InputView {
    fun inputPurchaseAmount():Int {
        println("Please enter the purchase amount.")
        return try {
            val purchaseAmount = Console.readLine().toInt()
            require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than zero." }
            require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
            purchaseAmount
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            inputPurchaseAmount()
        }
    }

    fun inputLottoNumber():List<Int> {
        println("\nPlease enter last week's winning numbers.")
        try {
            val input = Console.readLine().removeWhiteSpaces()
            val winningNumbers = input.split(",").map {
                it.toIntOrNull() ?: throw IllegalArgumentException("All numbers must be valid integers")
            }
            require(winningNumbers.size == 6) { "[ERROR] You must enter exactly 6 numbers." }
            require(winningNumbers.distinct().size == winningNumbers.size) { "[ERROR] You cannot enter duplicate numbers." }
            require(winningNumbers.all { it in 1..45 }) { "[ERROR] All numbers must be between 1 and 45." }
            return winningNumbers
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return inputLottoNumber()
        }
    }

    private fun String.removeWhiteSpaces() = replace("\\s".toRegex(), "")

    fun inputBonusNumber(winningNumbers: List<Int>):Int {
        println("\nPlease enter the bonus number.")
        try {
            val input = Console.readLine()
            val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be a valid integer.")
            require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
            require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number cannot be one of the winning numbers." }
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return inputBonusNumber(winningNumbers)
        }
    }
}

object OutputView {
    fun printTickets(lottoTickets: List<Lotto>) {
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        for (lotto in lottoTickets) {
            println(lotto.getNumbers().sorted().joinToString(prefix="[", postfix="]", separator = ", "))
        }
    }

    fun printResultStatistics(result: Map<ResultRank, Int>) {
        println("Winning Statistics")
        println("---")
        ResultRank.entries
            .filter { it != ResultRank.NO_WIN }
            .sortedBy { it.matchCount }
            .forEach { rank ->
                val count = result.getOrDefault(rank, 0)
                println("${rank.matchCount} Matches${rank.bonusText} (${formatMoney(rank.prizeMoney)} KRW) – $count tickets")
            }
    }

    private fun formatMoney(amount: Int): String {
        return amount.toString().replace(Regex("(?<=\\d)(?=(\\d{3})+(?!\\d))"), ",")
    }

    fun printProfitRate(profitRate: Double) {
        val formattedProfitRate = String.format("%.1f", profitRate)
        println("Total return rate is $formattedProfitRate%.")
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
        repeat (ticketQuantity) {
            val lotto = Lotto(generateTicketNumbers())
            tickets.add(lotto)
        }
    }

    private fun generateTicketNumbers(): List<Int> {
        val ticketNumbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return ticketNumbers
    }

    fun calculateResults(tickets: List<Lotto>, winningLotto: WinningLotto): Map<ResultRank, Int> {
        val rankCounts = mutableMapOf<ResultRank, Int>()

        tickets.forEach { ticket ->
            val rank = winningLotto.match(ticket)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1

        }
        return rankCounts
    }
}

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int)
{
    init {
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == winningNumbers.size) { "[ERROR] Winning numbers cannot contain duplicates." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number cannot be one of the winning numbers." }
    }

    fun match(ticket: Lotto): ResultRank {
        val matchCount = ticket.matchNumbers(winningNumbers)
        val containsBonus = ticket.contains(bonusNumber)
        return getResultRank(matchCount, containsBonus)

    }

    private fun getResultRank(matchCount: Int, containsBonus: Boolean): ResultRank {
        require(matchCount in 0..6) { "[ERROR] Match count must be between 0 and 6." }
        return when {
            matchCount == 6 -> ResultRank.SIX
            matchCount == 5 && containsBonus -> ResultRank.FIVE_BONUS
            matchCount == 5 -> ResultRank.FIVE
            matchCount == 4 -> ResultRank.FOUR
            matchCount == 3 -> ResultRank.THREE
            else -> ResultRank.NO_WIN
        }
    }
}