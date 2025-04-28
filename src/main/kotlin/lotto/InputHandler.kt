package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        private const val LOTTO_PRICE = 1000
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val REQUIRED_NUMBERS_COUNT = 6
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                //println("Please enter the purchase amount.")
                val input = Console.readLine().trim()
                val amount = input.toInt()
                require(amount >= MIN_PURCHASE_AMOUNT) {
                    "Purchase amount must be at least ${MIN_PURCHASE_AMOUNT}KRW."
                }
                require(amount % LOTTO_PRICE == 0) {
                    "Purchase amount must be divisible by $LOTTO_PRICE."
                }
                return amount
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                //println("\nPlease enter the winning numbers (comma-separated):")
                val input = Console.readLine().trim()
                val numbers = input.split(",")
                    .map { it.trim().toInt() }
                    .distinct()
                require(numbers.size == REQUIRED_NUMBERS_COUNT) {
                    "Please enter exactly $REQUIRED_NUMBERS_COUNT unique numbers."
                }
                require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) {
                    "Lotto numbers must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
                }
                return numbers.sorted()
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter valid numbers.")
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
               // println("\nPlease enter the bonus number:")
                val input = Console.readLine().trim()
                val bonus = input.toInt()
                require(bonus in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                    "Bonus number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
                }
                require(bonus !in winningNumbers) {
                    "Bonus number must not duplicate winning numbers."
                }
                return bonus
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}