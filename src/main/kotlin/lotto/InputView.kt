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

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val input = Console.readLine().toIntOrNull()
            try {
                validatePurchaseAmount(input)
                return input!!
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    fun readWinningNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")
            val input = Console.readLine()
            try {
                val winningNumbers = input.split(",").map {
                    val parsedNumber = it.trim().toIntOrNull()
                    validateLotteryNumber(parsedNumber)
                    parsedNumber!!
                }
                validateLotteryNumbers(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message) // [ERROR] 메시지 출력
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number.")
            val input = Console.readLine().toIntOrNull()
            try {
                validateLotteryNumber(input)
                validateBonusNumber(input!!, winningNumbers)
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message) // [ERROR] 메시지 출력
            }
        }
    }
}
