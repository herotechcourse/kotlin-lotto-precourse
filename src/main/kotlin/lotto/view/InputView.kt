package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers
import java.util.Scanner

object InputView {
    private fun resetConsoleScanner() {
        try {
            val field = Console::class.java.getDeclaredField("scanner")
            field.isAccessible = true
            field.set(null, Scanner(System.`in`))
        } catch (_: Exception) { /* ignore */ }
    }

    fun readPurchaseAmount(): Int {
        resetConsoleScanner()
        println("Please enter the purchase amount.")
        val raw = Console.readLine().orEmpty().trim()
        val amount = raw.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.")
        PurchaseAmount(amount)
        return amount
    }

    fun readWinningNumbers(): WinningNumbers {
        resetConsoleScanner()
        println("Please enter the winning numbers (comma separated).")
        val main = Console.readLine().orEmpty()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.") }

        resetConsoleScanner()
        println("Please enter the bonus number.")
        val bonus = Console.readLine().orEmpty().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")

        return WinningNumbers(main, bonus)
    }
}
