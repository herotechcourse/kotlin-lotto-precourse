package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val line = Console.readLine()
        val amount = line.toIntOrNull()
        requireNotNull(amount) { "[ERROR] Purchase amount must be a number." }
        return amount
    }

    fun readWinningNumbers(): Lotto {
        println("Please enter last week's winning numbers.")
        val raw = Console.readLine()
        val nums = raw.split(",")
            .mapNotNull { it.trim().toIntOrNull() }
        require(nums.size == 6) {
            "[ERROR] Winning numbers must be 6 comma-separated numbers."
        }
        return Lotto(nums)
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val line = Console.readLine()
        val num = line.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
        return num
    }
}
