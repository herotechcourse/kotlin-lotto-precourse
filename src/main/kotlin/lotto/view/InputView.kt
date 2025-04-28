package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        while (true) {
            val raw = Console.readLine().orEmpty().trim()
            val amount = raw.toIntOrNull()
            if (amount == null) {
                println("[ERROR] Invalid number format.")
                continue
            }
            try {
                PurchaseAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): WinningNumbers {
        println("Please enter last week's winning numbers.")
        while (true) {
            val mainRaw = Console.readLine().orEmpty().trim()
            val main = try {
                mainRaw.split(",").map { it.trim().toInt() }
            } catch (_: Exception) {
                println("[ERROR] Winning numbers must be numeric.")
                continue
            }

            println("Please enter the bonus number.")
            val bonusRaw = Console.readLine().orEmpty().trim()
            val bonus = bonusRaw.toIntOrNull()
            if (bonus == null) {
                println("[ERROR] Bonus number must be numeric.")
                continue
            }

            try {
                return WinningNumbers(main, bonus)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
