package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAmount(): Int {
        println("Please enter the purchase amount.")
        val amount = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] You must enter a valid number.")
        }
        if (amount % 100 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
        return amount
    }

    fun readWinningNumbers() : List<Int> {
        println("Please enter last week's winning numbers.")
        val winningNumbers = try {
            Console.readLine().split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] You must enter a valid number.")
        }
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter the 6 numbers.")
        }
        if (winningNumbers.distinct().size != winningNumbers.size) {
            throw IllegalArgumentException("[ERROR] You must not enter duplicate numbers.")
        }
        if (winningNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] You must enter numbers between 1 and 45.")
        }
        return winningNumbers
    }

    fun readBonusNumber() : Int{
        println("Please enter the bonus number.")
        val bonusNumber = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] You must enter a valid number.")
        }
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] You must enter number between 1 and 45.")
        }
        return bonusNumber
    }
}