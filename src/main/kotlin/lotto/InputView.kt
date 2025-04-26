package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun promptPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it >= 1000 && it % 1000 == 0 }
            ?: throw IllegalArgumentException("Purchase amount must be a multiple of 1,000 KRW.")
    }

    fun promptWinningNumbers(): Pair<List<Int>, Int> {
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine().split(",").map { it.trim().toInt() }
        println("Please enter the bonus number:")
        val bonusNumber = Console.readLine().toInt()

        if (winningNumbers.toSet().size != 6 || winningNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        if (bonusNumber in winningNumbers || bonusNumber !in 1..45) {
            throw IllegalArgumentException("Bonus number must be unique and between 1 and 45.")
        }

        return Pair(winningNumbers, bonusNumber)
    }
}
