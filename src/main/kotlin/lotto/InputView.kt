package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object InputView {

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        val amount = input?.toIntOrNull()

        if (amount == null || amount < 1000) {
            println("[ERROR] Invalid amount. Purchase must be at least 1000.")
            return getPurchaseAmount()
        }

        return amount
    }


    fun getWinningNumbers(): List<Int> {
        println("Please enter last week 's winning numbers.")
        val input = Console.readLine()
        val numbers = input?.split(",")?.mapNotNull { it.toIntOrNull() }
        if (numbers?.size != 6 || numbers.any { it !in 1..45 }) {
            println("[ERROR] Lotto must contain exactly 6 numbers between 1 and 45.")
            return getWinningNumbers()
        }
        return numbers
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonusNum = input?.toIntOrNull()
        if (bonusNum == null || bonusNum !in 1..45) {
            println("[ERROR] Lotto numbers must be between 1 and 45.")
            return getBonusNumber()
        }
        return bonusNum
}

}