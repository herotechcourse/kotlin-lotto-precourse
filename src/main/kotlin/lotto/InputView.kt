package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val raw = Console.readLine()
        val amount = raw.toIntOrNull()
        require(amount != null && amount % 1000 == 0) {
            "[ERROR] Please enter a valid amount divisible by 1000."
        }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val raw = Console.readLine()
        val nums = raw.split(",").map { it.trim().toIntOrNull() }
        require(nums.size == 6 && nums.all { it != null }) {
            "[ERROR] Must input exactly 6 numbers."
        }
        return nums.filterNotNull()
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val raw = Console.readLine()
        val num = raw.toIntOrNull()
        require(num != null && num in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }
        return num
    }
}