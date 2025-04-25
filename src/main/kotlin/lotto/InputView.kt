package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class InputView {

    fun getAmountOfTickets(): Long {
        while (true) {
            println("\nPlease enter the purchase amount.")
            val input = Console.readLine()
            val amount = input.toLongOrNull()
            if (amount != null && amount % 1000 == 0L) return amount
            println("[ERROR] Number of tickets must be divisible by 1000.")
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            println("\nPlease enter last week's winning numbers.")
            val input = Console.readLine()
            val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
            if (numbers.size == 6 && numbers.all { it in 1..45 } && numbers.distinct().size == 6) {
                return numbers
            }
            println("[ERROR] Please enter exactly 6 unique numbers between 1 and 45.")
        }
    }

    fun getBonusNumber(): Int {
        while (true) {
            println("\nPlease enter the bonus number.")
            val input = Console.readLine()
            val bonus = input.toIntOrNull()
            if (bonus != null && bonus in 1..45) {
                return bonus
            }
            println("[ERROR] Please enter a valid bonus number between 1 and 45.")
        }
    }

    fun generateTickets(amount: Long): List<Lotto> {
        return (1..amount / 1000).map {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}
