package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val purchaseAmountInput = Console.readLine()
        val purchaseAmount = purchaseAmountInput.toIntOrNull()
        return purchaseAmount?.takeIf { it > 0 && it % 1000 == 0 }
            ?: throw IllegalArgumentException("Amount must be a positive number that is divisible by 1000")
    }

    fun getWinningNumbers(): Set<Int> {
        println("Please enter last week's winning numbers (comma separated):")
        val winningNumbersInput = Console.readLine()
        val winningNumbers = winningNumbersInput.split(" ").map{it.toInt()}.toSet()
        require(winningNumbers.size == 6 && winningNumbers.all { it in 1..45}) {
            "Winning numbers must be 6 unique numbers between 1 and 45."
        }
        return winningNumbers
    }
}