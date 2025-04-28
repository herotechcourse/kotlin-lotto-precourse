package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val lottoTickets = LottoMachine.issueTickets(purchaseAmount)

        OutputView.printLottoTickets(lottoTickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoResult = LottoResult.calculate(lottoTickets, winningLotto)

        OutputView.printStatistics(lottoResult)
    }
}

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
        if (numbers.size != 6 || numbers.toSet().size != 6) throw IllegalArgumentException("[ERROR] Must be 6 unique numbers.")
        if (numbers.any { it !in 1..45 }) throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        return numbers.sorted()
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
        if (bonus !in 1..45) throw IllegalArgumentException("[ERROR] Bonus must be between 1 and 45.")
        return bonus
    }
}

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
        if (numbers.size != 6 || numbers.toSet().size != 6) throw IllegalArgumentException("[ERROR] Must be 6 unique numbers.")
        if (numbers.any { it !in 1..45 }) throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        return numbers.sorted()
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
        if (bonus !in 1..45) throw IllegalArgumentException("[ERROR] Bonus must be between 1 and 45.")
        return bonus
    }
}

object OutputView {
    fun printLottoTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.numbers) }
    }

    fun printStatistics(result: LottoResult) {
        println("\nWinning Statistics")
        println("---")
        Rank.entries.sortedBy { it.rank }.forEach { rank ->
            if (rank != Rank.NONE) {
                println(rank.message(result.rankCount[rank] ?: 0))
            }
        }
        println("Total return rate is ${"%.1f".format(result.profitRate)}%.")
    }
}
