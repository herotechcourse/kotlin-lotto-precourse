package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

class ConsoleInputReader: InputReader {
    override fun readPurchaseAmount(): PurchaseAmount {
        println("Please enter the purchase amount.")
        val amount: Int? = Console.readLine().toIntOrNull()
        require(amount != null) {"[ERR] Purchase amount must be a number."}

        return PurchaseAmount(amount)
    }

    override fun readWinningNumbers(): WinningNumbers {
        TODO("Not yet implemented")
    }
}
