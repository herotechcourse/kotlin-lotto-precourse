package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

object InputView {
    fun readPurchaseAmount(): Int {
        println("구매 금액을 입력해 주세요.")
        val raw = Console.readLine().orEmpty().trim()
        val amount = raw.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.")
        PurchaseAmount(amount)
        return amount
    }

    fun readWinningNumbers(): WinningNumbers {
        println("당첨 번호를 입력해 주세요. (쉼표로 구분)")
        val main = Console.readLine().orEmpty()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.") }
        println("보너스 번호를 입력해 주세요.")
        val bonus = Console.readLine().orEmpty().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
        return WinningNumbers(main, bonus)
    }
}
