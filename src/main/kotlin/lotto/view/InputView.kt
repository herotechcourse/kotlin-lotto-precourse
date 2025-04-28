package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine() ?: throw IllegalArgumentException(lotto.ERROR_MESSAGE)
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException(lotto.ERROR_MESSAGE)
        require(amount > 0 && amount % 1000 == 0) {
            lotto.ERROR_MESSAGE
        }
        return amount
    }

    fun readWinningNumbers(): Set<Int> {
        println("Please enter last week's winning numbers.")
        val nums = Console.readLine().split(",").map { it.toInt() }
        require(nums.size == 6 && nums.toSet().size == 6 && nums.all { it in 1..45 }) {
            lotto.ERROR_MESSAGE
        }
        return nums.toSet()
    }

    fun readBonusNumber(winning: Set<Int>): Int {
        println("Please enter the bonus number.")
        val bonus = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(lotto.ERROR_MESSAGE)
        require(bonus in 1..45 && bonus !in winning) {
            lotto.ERROR_MESSAGE
        }
        return bonus
    }



}
