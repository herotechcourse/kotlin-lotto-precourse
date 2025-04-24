package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount for lottery tickets:")
        return Console.readLine()?.toIntOrNull()?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
    }

    fun requestWinningNumbers(): List<Int> {
        println("Please enter the winning numbers (comma-separated):")
        return Console.readLine()?.split(",")?.map { it.trim().toInt() }
            ?: throw IllegalArgumentException("[ERROR] Invalid input")
    }

    fun requestBonusNumber(): Int {
        println("Please enter the bonus number:")
        return Console.readLine()?.toInt()
            ?: throw IllegalArgumentException("[ERROR] Invalid input")
    }
}
