package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return try {
            val amount = input.toInt()
            if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000 KRW.")
            }
            amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid input. Please enter a number.")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        val input = Console.readLine()
        return try {
            input.split(",")
                .map { it.trim().toInt() }
                .also { validateLottoNumbers(it) }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid input. Please enter numbers separated by commas.")
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        return try {
            val bonusNumber = Console.readLine().toInt()
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR] Bonus number cannot be one of the winning numbers.")
            }
            bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid input. Please enter a number.")
        }
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must consist of 6 numbers.")
        }
        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be unique.")
        }
    }
}