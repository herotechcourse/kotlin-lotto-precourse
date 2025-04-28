package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    private fun validatePurchaseAmount(purchaseAmount: Int?) {
        requireNotNull(purchaseAmount) { "[ERROR] Please enter a number." }
        require(purchaseAmount > 0) { "[ERROR] The amount must be greater than 0." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] The amount must be divisible by 1,000." }
    }

    private fun validateLotteryNumber(lotteryNumber: Int?) {
        requireNotNull(lotteryNumber) { "[ERROR] Please enter a number." }
        require(lotteryNumber in 1..45) { "[ERROR] Each number must be between 1 and 45." }
    }

    private fun validateLotteryNumbers(lotteryNumbers: List<Int>) {
        require(lotteryNumbers.size == 6) { "[ERROR] The lottery numbers must consist of 6 numbers." }
        require(lotteryNumbers.toSet().size == lotteryNumbers.size) { "[ERROR] The lottery numbers must consist of unique numbers." }
    }

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().toIntOrNull()
        validatePurchaseAmount(input)
        return input!!
    }


    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val winningNumbers = Console.readLine().split(",").map {
            val parsedNumber = it.trim().toIntOrNull()
            validateLotteryNumber(parsedNumber)
            parsedNumber!!
        }

        validateLotteryNumbers(winningNumbers)

        return winningNumbers
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val bonusNumber = Console.readLine().toIntOrNull()
        validateLotteryNumber(bonusNumber)

        return bonusNumber!!
    }
}