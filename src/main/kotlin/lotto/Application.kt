package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val purchaseAmount = InputView().purchaseAmount()
            val tickets = Application().generateLottoTickets(purchaseAmount)
            OutputView().displayTickets(tickets)

            val winningNumbers = InputView().inputWinningNumbers()
            val bonusNumber = InputView().inputBonusNumber(winningNumbers)

            val results = Application().countWinningTickets(tickets, winningNumbers, bonusNumber)
            val totalPrize = Application().calculateTotalPrize(results)

            OutputView().displayResults(results)
            OutputView().displayReturnRate(totalPrize, tickets.size)
        }
    }

    private fun generateLottoTickets(purchaseAmount: Long): List<Lotto> {
        val quantityOfTickets = (purchaseAmount / 1000).toInt()
        val tickets = mutableListOf<Lotto>()
        repeat(quantityOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            tickets.add(Lotto(numbers))
        }
        return tickets
    }

    private fun countWinningTickets(
        tickets: List<Lotto>,
        winningNumbers: List<Byte>,
        bonusNumber: Byte
    ): Map<LottoPrize, Int> {
        val results = mutableMapOf<LottoPrize, Int>()
        LottoPrize.entries.forEach { results[it] = 0 }

        for (ticket in tickets) {
            val prize = determinePrize(ticket, winningNumbers, bonusNumber)
            results[prize] = results[prize]!! + 1
        }

        return results
    }

    private fun determinePrize(
        ticket: Lotto,
        winningNumbers: List<Byte>,
        bonusNumber: Byte
    ): LottoPrize {
        val ticketNumbers = ticket.getNumbers()
        val matchCount = ticketNumbers.count { winningNumbers.contains(it.toByte()) }
        val hasBonus = ticketNumbers.contains(bonusNumber.toInt())

        return LottoPrize.fromMatchResult(matchCount, hasBonus)
    }

    private fun calculateTotalPrize(results: Map<LottoPrize, Int>): Long {
        var totalPrize = 0L
        for (entry in results.entries) {
            val prize = entry.key
            val count = entry.value
            totalPrize += prize.prize * count
        }
        return totalPrize
    }
}

class InputView {
    fun purchaseAmount(): Long {
        println("Please enter the purchase amount.")
        val input = Console.readLine()?.trim()
        val purchaseLotto = input?.toLongOrNull()
        validatePurchaseAmount(purchaseLotto)
        return purchaseLotto!!
    }

    private fun validatePurchaseAmount(purchaseLotto: Long?) {
        if (purchaseLotto == null) {
            throw IllegalArgumentException("[ERROR] Amount cannot be empty and must be a valid number")
        }
        if (purchaseLotto <= 0L) {
            throw IllegalArgumentException("[ERROR] Amount cannot be zero and negative")
        }
        if (purchaseLotto % 1000L != 0L) {
            throw IllegalArgumentException("[ERROR] Amount must be a multiply of 1000")
        }
    }

    fun inputWinningNumbers(): List<Byte> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()

        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty")
        }
        try {
            val winningNumbers = input.split(",").map { it.trim().toByte() }
            validateWinningNumbers(winningNumbers)
            return winningNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format. Please enter valid numbers.")
        }
    }

    private fun validateWinningNumbers(winningNumbers: List<Byte>) {
        if (winningNumbers.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Winning Numbers cannot be empty")
        }
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning Numbers should have 6 numbers")
        }
        if (winningNumbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning Numbers must not be duplicated")
        }
        if (winningNumbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] Winning Numbers should between 1 - 45")
        }
    }

    fun inputBonusNumber(winningNumbers: List<Byte>): Byte {
        println("\nPlease enter the bonus numbers.")
        val input = Console.readLine()

        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty")
        }
        try {
            val bonusNumber = input.toByte()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format. Please enter valid numbers.")
        }
    }

    private fun validateBonusNumber(bonusNumber: Byte, winningNumbers: List<Byte>) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw IllegalArgumentException("[ERROR] Bonus Number should between 1 - 45")
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] Bonus Number must not be the same as any of the Winning Numbers")
        }
    }
}

class OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun displayResults(results: Map<LottoPrize, Int>) {
        println("\nWinning Statistics")
        println("--------------------")
        for (prize in LottoPrize.entries) {
            if (prize != LottoPrize.NONE) {
                val matchText = when (prize) {
                    LottoPrize.FIRST -> "6 Matches"
                    LottoPrize.SECOND -> "5 Matches + Bonus Ball"
                    LottoPrize.THIRD -> "5 Matches"
                    LottoPrize.FOURTH -> "4 Matches"
                    LottoPrize.FIFTH -> "3 Matches"
                    else -> ""
                }
                val formattedPrize = "%,d".format(prize.prize)
                println("$matchText (${formattedPrize} KRW) - ${results[prize]} tickets")
            }
        }
    }

    fun displayReturnRate(totalPrize: Long, ticketCount: Int) {
        val purchaseAmount = ticketCount * 1000L
        val returnRate = (totalPrize.toDouble() / purchaseAmount.toDouble()) * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}

enum class LottoPrize(val matchCount: Int, val hasBonus: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun fromMatchResult(matchCount: Int, hasBonus: Boolean): LottoPrize {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}