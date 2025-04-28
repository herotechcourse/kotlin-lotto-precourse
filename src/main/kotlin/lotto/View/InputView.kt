package lotto.view
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        try {
            val amount = input.toInt()

            require(amount > 0) { "[ERROR] Purchase Amount should be postivie number." }
            require(amount % 1000 == 0) { "[ERROR] Purchase Amount should be a multiple of 1000." }

            return amount
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] Invalid Purchase Amount input.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        try {
            val numbers = input.split(",").map { it.toInt() }

            require(numbers.size == 6) { "[ERROR] Numbers must be in the range 1 ~ 45" }
            require(numbers.all { number -> number in 1..45 }) { "[ERROR] Numbers must be in the range 1 ~ 45." }
            require(numbers.distinct().size == 6) { "[ERROR] Every numbers should be unique" }

            return numbers
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] Invalid Winning Numbers input.")
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()

        try {
            val number = input.toInt()
            require(number in 1..45) { "[ERROR] Bonus Number must be in the range 1 ~ 45." }
            return number
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] Invalid bonus number input.")
        }
    }
}